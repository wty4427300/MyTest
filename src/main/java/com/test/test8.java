package com.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Objects;

public class test8 {
    public static void main(String[] args) {
        String filePath = Objects.requireNonNull(test8.class.getClassLoader().getResource("export_urls.csv")).getPath();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r"); FileChannel channel = file.getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            byte[] data = new byte[(int) channel.size()];
            buffer.get(data);
            String[] lines = new String(data).split("\n");
            for (String line : lines) {
                String[] values = line.split(",");
                System.out.println(Arrays.toString(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
