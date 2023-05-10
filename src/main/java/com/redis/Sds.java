package com.redis;

import java.util.Arrays;

public class Sds {
    private byte[] buffer;
    private int len;
    private int free;
    private int alloc;

    public Sds() {
        this.buffer = new byte[16];
        this.len = 0;
        this.free = 16;
        this.alloc = 16;
    }

    public Sds(String str) {
        this.buffer = str.getBytes();
        this.len = str.length();
        this.free = 0;
        this.alloc = str.length();
    }

    public int length() {
        return this.len;
    }

    public int available() {
        return this.free;
    }

    public byte[] getBytes() {
        return Arrays.copyOfRange(this.buffer, 0, this.len);
    }

    public void append(byte[] bytes) {
        int newLen = this.len + bytes.length;
        if (newLen > this.alloc) {
            int newAlloc = Math.max(newLen, this.alloc * 2);
            byte[] newBuffer = new byte[newAlloc];
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.len);
            this.buffer = newBuffer;
            this.alloc = newAlloc;
        }
        System.arraycopy(bytes, 0, this.buffer, this.len, bytes.length);
        this.len = newLen;
        this.free = this.alloc - newLen;
    }

    public void append(String str) {
        this.append(str.getBytes());
    }

    @Override
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }
}

