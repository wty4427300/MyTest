package com.ftest.bufferTest;

import java.nio.ByteBuffer;
//只读buffer
public class ReaderOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocate(64);
        for (int i=0;i<64;i++){
            byteBuffer.put((byte)(i));
        }

        byteBuffer.flip();

        ByteBuffer readBuffer=byteBuffer.asReadOnlyBuffer();
        System.out.println(readBuffer.getClass());

        while (readBuffer.hasRemaining()){
            System.out.println(readBuffer.get());
        }
        //mark
        byteBuffer.position(0).mark();
        byteBuffer.reset();
    }
}
