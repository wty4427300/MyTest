package com.concurrent.mywecaht;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int port = 6666;

    //构造器
    public GroupChatServer() {
        try {
            //得到选择器
            selector = Selector.open();
            //初始化ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(port));
            //设置非阻塞
            listenChannel.configureBlocking(false);
            //将channel注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                        //移除当前key防止重复登陆
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

    private void readData(SelectionKey key) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            int count = socketChannel.read(byteBuffer);
            if (count > 0) {
                //把buffer的数据转成字符串
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

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
