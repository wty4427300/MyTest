package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class test1016 {
    public boolean queryString(String s, int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean queryString1(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "0110";
        int n = 4;
        test1016 test1016 = new test1016();
        boolean queried = test1016.queryString(str, n);
        System.out.println(queried);
        System.out.println(Integer.toBinaryString(4));
    }
}
