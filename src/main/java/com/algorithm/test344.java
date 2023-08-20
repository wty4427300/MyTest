package com.algorithm;

public class test344 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char st = s[i];
            char en = s[s.length - 1 - i];
            s[i] = en;
            s[s.length - 1 - i] = st;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        test344 test344 = new test344();
        test344.reverseString(s);
        System.out.println(s);
    }
}
