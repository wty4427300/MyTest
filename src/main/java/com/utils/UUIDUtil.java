package com.utils;
import java.util.UUID;

public class UUIDUtil {
    public UUIDUtil() {
    }

    public static String create() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String create2() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(create());
    }
}
