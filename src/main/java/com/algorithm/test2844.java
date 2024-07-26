package com.algorithm;

public class test2844 {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean find0 = false, find5 = false;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0' || num.charAt(i) == '5') {
                if (find0) {
                    return n - i - 2;
                }
                if (num.charAt(i) == '0') {
                    find0 = true;
                } else {
                    find5 = true;
                }
            } else if (num.charAt(i) == '2' || num.charAt(i) == '7') {
                if (find5) {
                    return n - i - 2;
                }
            }
        }
        if (find0) {
            return n - 1;
        }
        return n;
    }
}
