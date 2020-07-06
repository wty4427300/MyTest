# 本篇文章实现一个简单群聊服务器

## 一.编写服务器

### 实现功能
```json
1.实现上线下线
```
### 1.开始
```json
public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int port = 6666;
    
        //构造器
        public GroupChatServer() {
            try {
                //初始化选择器
                selector = Selector.open();
                //初始化ServerSocketChannel
                listenChannel = ServerSocketChannel.open();
                //绑定端口
                listenChannel.socket().bind(new InetSocketAddress(port));
                //设置非阻塞
                listenChannel.configureBlocking(false);
                //将channel注册到selector,并设置关注事件
                listenChannel.register(selector, SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
```

### 2.事件处理
```json
    //监听
    public void listen() {
        System.out.println("监听线程: " + Thread.currentThread().getName());
        try {
            while (true) {
                int count = selector.select(1000);
                if (count > 0) {
                    //有事件处理
                    //遍历得到的selectionKey集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isValid()) {
                            if (key.isAcceptable()) {
                                SocketChannel sc = listenChannel.accept();
                                sc.configureBlocking(false);
                                sc.register(selector, SelectionKey.OP_READ);
                                //提示
                                System.out.println(sc.getRemoteAddress() + "加入了聊天室");
                            }
                            if (key.isReadable()) {
                                readData(key);
                            }
                        }
                        //移除当前key防止事件的重复处理
                        iterator.remove();
                    }
                } else {
//                    System.out.println("无消息");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```
当等待到连接事件的时候,则可以视为,客户端发送消息.一个连接建立成功可以视为一个用户上线

### 3.监听到读事件的处理
```json
private void readData(SelectionKey key) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            int count = socketChannel.read(byteBuffer);
            if (count > 0) {
                String msg = new String(byteBuffer.array());
                //输出消息
                System.out.println("客户端:" + msg);
                //向其他客户端转发消息
                sendInfoOtherCli(msg, socketChannel);
            } else if (count == -1) {
                System.out.println(socketChannel.getRemoteAddress() + "离线了");
                key.cancel();
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                String msg = socketChannel.getRemoteAddress() + "离线了";
                System.out.println(msg);
                sendInfoOtherCli(msg, socketChannel);
                key.cancel();
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
```
下线处理在读事件的处理中实现.当连接断开时selector会触发一个读事件,这时候socketchannel.read()会返回-1.我们点入read()方法会发现当连接断开时会抛出NotYetConnectedException()异常，并返回-1.由此我们就可以判断当前通道连接断开，用户下线.之后需要注销当前selectionkey的注册,并关闭通道.此处ubuntu与windows有不同的表现linux平台下会直接返回-1，而windows则会抛出异常.当正常读出消息后我们需要将消息同步给其他用户.

### 4.发送消息给其他用户
```json
    //转发消息给其他人
    private void sendInfoOtherCli(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器消息转发");
        for (SelectionKey key : selector.keys()) {
            Channel tarChannel = key.channel();
            if (tarChannel instanceof SocketChannel && tarChannel != self) {
                SocketChannel dest = (SocketChannel) tarChannel;
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(byteBuffer);
                byteBuffer.clear();
            }
        }
    }
```
这里的处理也很简单，只要将消息发给除本连接以外的所有连接即可（其实这里偷懒了,正确的做法是回注一个写事件进行处理）

### 5.主函数
```json
    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
```

## 二.客户端
```json
public class GroupChatCli {
    private final String HOST = "127.0.0.1";
    private final int port = 6666;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatCli() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, port));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + ":上线");
    }

    //向服务端发送消息
    private void sendInfo(String info) {
        info = username + "说：" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取从服务端回复的消息
    private void readInfo() {
        try {
            int readCount = selector.select();
            if (readCount > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        sc.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg.trim());
                        byteBuffer.clear();
                        iterator.remove();
                    }
                }
            } else {
//                System.out.println("没有事件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        GroupChatCli chatCli = new GroupChatCli();
        new Thread(() -> {
            while (true) {
                chatCli.readInfo();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            chatCli.sendInfo(s);
        }
    }
}
```