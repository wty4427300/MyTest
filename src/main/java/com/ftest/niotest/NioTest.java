package com.ftest.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTest {
    public static void main(String[] args) throws IOException {
        //创建serversocketchannel
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //得到一个selecotr对象
        Selector selector=Selector.open();
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serversocketchannel注册到 selector 关心时间为op_accept
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while(true){
            if(selector.select(1000)==0){
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            //有事件获取selectionkey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历集合
            Iterator<SelectionKey> keyIterator=selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //根据不同事件
                SelectionKey key=keyIterator.next();
                if (key.isAcceptable()){
                    System.out.println("是新连接事件");
                    //给这个连接生成一个socketchannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("生成了一个socketchannel");
                    socketChannel.configureBlocking(false);
                    //注册到selector上,设置关注事件，并关联一个buffer
                    socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                    System.out.println("注册的数量"+selector.keys().size());
                }
                if (key.isReadable()){
                    //根据key获取channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取该chnannel的buffer
                    ByteBuffer byteBuffer = (ByteBuffer)key.attachment();
                    channel.read(byteBuffer);
                    System.out.println("从客户端发来的数据"+new String(byteBuffer.array()));
                    byteBuffer.clear();
                    channel.close();
                }
                //删除操作完的key
                keyIterator.remove();
            }
        }
    }
}
