package com.ftest.BufferTest;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//让文件在内存(堆外内存)中修改，操作系统不需要cp
public class MappedByteTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile("1.txt","rw");
        FileChannel fileChannel=randomAccessFile.getChannel();
        //参数1读写模式
        //参数2可以修改的起始位置
        //参数3将1.txt的多少个字节映射到内存，可以直接修改的范围就是0-5(最多修改5个字节)
        MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(1,(byte)'s');
        mappedByteBuffer.put(1,(byte)'b');
        randomAccessFile.close();
        System.out.println("修改完成");
    }
}
