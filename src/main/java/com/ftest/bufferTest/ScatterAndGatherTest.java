package com.ftest.bufferTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

//Scattering数据写入buffer时，可采用buffer依次写入
//Gatherin读取是可以依次读取
//也就是 写满一个写下一个，读完一个读下一个
public class ScatterAndGatherTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress=new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers=new ByteBuffer[2];
        byteBuffers[0]=ByteBuffer.allocate(5);
        byteBuffers[1]=ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel channel=serverSocketChannel.accept();
        //假定从客户端接收8字节
        int messageLength=8;
        while (true){
            int byteRead=0;
            while (byteRead< messageLength){
                long l=channel.read(byteBuffers);
                byteRead+=l;
                System.out.println("读取的字节数byteRead="+byteRead);
                //
                Arrays.stream(byteBuffers).map(buffer->buffer.position()+"\t"+buffer.limit()).forEach(System.out::println);

            }
            Arrays.asList(byteBuffers).forEach(Buffer::flip);

            //将数据读出显示到客户端
            long byteWirte=0;
            while (byteWirte< messageLength){
                long l=channel.write(byteBuffers);
                byteWirte+=l;
                System.out.println("写出的字节数byteWirte="+byteWirte);
            }

            Arrays.asList(byteBuffers).forEach(Buffer::clear);
            System.out.println("读取数量："+byteRead+"\n"+"写出数量："+byteWirte+"\n"+"从客户端读取最大长度："+messageLength);

        }
    }
}
