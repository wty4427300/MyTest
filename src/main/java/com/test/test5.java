package com.test;

import java.util.Arrays;

public class test5 {
    public static void main(String[] args) {
        String code = "";
        String[] split = code.split("\n");
        Arrays.stream(split).forEach(
                it -> {
                    System.out.println("\'" + it + "\'" + ",");
                }
        );
        System.out.println(split.length);
    }
}
