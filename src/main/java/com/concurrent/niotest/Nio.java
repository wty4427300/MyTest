package com.concurrent.niotest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class Nio {
    public static void main(String[] args) throws IOException {
        IntBuffer intBuffer=IntBuffer.allocate(5);
        for (int i=0;i<intBuffer.capacity();i++){
            intBuffer.put(i*2);
        }
        //读写切换
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

        //文件读写
        String str="憨憨你好";
        FileOutputStream fileOutputStream=new FileOutputStream("/tmp/a.txt");

        FileChannel fileChannel=fileOutputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();

        //读

        File file=new File("/tmp/a.txt");
        FileInputStream fileInputStream=new FileInputStream(file);

        FileChannel fileChannel1=fileInputStream.getChannel();

        ByteBuffer byteBuffer1=ByteBuffer.allocate((int)file.length());

        fileChannel1.read(byteBuffer1);

        System.out.println(new String(byteBuffer1.array()));

        fileInputStream.close();

        //单通道读写
        File file1=new File("1.txt");
        FileInputStream fileInputStream12=new FileInputStream(file1);
        FileChannel fileChannel12=fileInputStream12.getChannel();
        FileOutputStream fileOutputStream13=new FileOutputStream("2.txt");
        FileChannel fileChannel13=fileOutputStream13.getChannel();
        ByteBuffer byteBuffer11=ByteBuffer.allocate((int)file1.length());
        while (true){
            //清空buffer重置标记
            byteBuffer11.clear();
            int i=fileChannel12.read(byteBuffer11);
            System.out.println(new java.lang.String(byteBuffer11.array()));
            if (i==-1){
                break;
            }
            byteBuffer11.flip();
            fileChannel13.write(byteBuffer11);
        }
        //只读buffer
        byteBuffer.asReadOnlyBuffer();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
