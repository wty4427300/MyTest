package com.redis;

import java.util.Arrays;

public class Sds {
    /**
     * 用来存储字符串
     */
    private byte[] buffer;
    /**
     * 当前字符串长度
     */
    private int len;
    /**
     * 可用空间大小
     */
    private int free;
    /**
     * 分配空间大小
     */
    private int alloc;

    public Sds() {
        this.buffer = new byte[16];
        this.len = 0;
        this.free = 16;
        this.alloc = 0;
    }

    public Sds(String str) {
        byte[] strBytes = str.getBytes();
        this.buffer = strBytes;
        this.len = str.length();
        this.free = 0;
        this.alloc = strBytes.length;
    }

    public int length() {
        return this.len;
    }

    public int available() {
        return this.free;
    }

    public byte[] getBytes() {
        return Arrays.copyOfRange(this.buffer, 0, this.alloc);
    }

    public void append(String str) {
        byte[] bytes = str.getBytes();
        //考虑中文的情况
        int newLen = this.len + str.length();
        int newAlloc = this.alloc + bytes.length;
        if (newAlloc > this.alloc) {
            //超出当前空间,需要扩容
            int alloc = Math.max(newAlloc, this.alloc * 2);
            byte[] newBuffer = new byte[alloc];
            //复制原字符串
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.alloc);
            this.buffer = newBuffer;
        }
        //添加新字符串
        System.arraycopy(bytes, 0, this.buffer, this.alloc, bytes.length);
        //更新属性
        this.alloc = newAlloc;
        this.len = newLen;
        this.free = this.buffer.length - this.alloc;
    }

    @Override
    public String toString() {
        return new String(this.buffer, 0, this.alloc);
    }

    public static void main(String[] args) {
        Sds sds = new Sds("夏天");
        sds.append("你好");
        System.out.println(sds);
    }
}

