package com.concurrent.mytest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *java sendfile() 的栗子
 */
public class MyNioTest {
    public static void main(String[] args) throws IOException {
        //创建流
        FileInputStream fileInputStream=new FileInputStream("3.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("4.txt");
        //获取channel
        FileChannel in=fileInputStream.getChannel();
        FileChannel out=fileOutputStream.getChannel();
        //拷贝
        out.transferFrom(in,0,in.size());
        //关闭流
        in.close();
        out.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
