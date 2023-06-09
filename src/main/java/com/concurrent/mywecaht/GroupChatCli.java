package com.concurrent.mywecaht;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

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
