package com.concurrent.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioTestClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供ip
        InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",6666);
        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("连接需要时间，客户端不会阻塞，可以做其他工作..");
            }
        }
        //连接成功就可以发送数据
        String s="老咸鱼了" ;
        ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());
        socketChannel.write(byteBuffer.asReadOnlyBuffer());
        socketChannel.close();
    }
}
