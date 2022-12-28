package com.algorithm;

public class test1750 {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            //判断左边相同的字符串
            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) {
                l++;
            }
            //判断右边相同的字符串
            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) {
                r--;
            }
            l++;
            r--;
        }
        return r - l + 1;
    }
}
