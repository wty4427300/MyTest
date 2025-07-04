package com.algorithm;

public class test3304 {
    public char kthCharacter(int k) {
        return (char) ('a' + (Integer.bitCount(k - 1) % 26));
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(5 - 1));
        System.out.println(('a' + (Integer.bitCount(5 - 1) % 26)));
        System.out.println((int)'a');
    }
}
