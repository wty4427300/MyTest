package com.algorithm_template.code;

public class ConsistentHashingHashFunction {

    // Redis CRC16算法
    private static final int CRC16_POLY = 0x1021;
    private static final int CRC16_INIT = 0xFFFF;

    public static int hashCode(String key) {
        byte[] bytes = key.getBytes();
        int crc = CRC16_INIT;
        for (byte b : bytes) {
            crc ^= (b & 0xff) << 8;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ CRC16_POLY;
                } else {
                    crc <<= 1;
                }
            }
        }
        return crc & 0xffff;
    }

    public static void main(String[] args) {
        // 测试不同键的CRC16哈希值
        String[] keys = {"Key-1", "Key-2", "Key-3", "Key-4", "Key-5"};
        for (String key : keys) {
            int hash = hashCode(key);
            System.out.println("Key: " + key + " => CRC16 Hash: " + hash);
        }
    }
}

