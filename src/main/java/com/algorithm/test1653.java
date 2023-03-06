package com.algorithm;

public class test1653 {
    public int minimumDeletions(String s) {
        char[] array = s.toCharArray();
        int del = 0;
        for (char c : array) {
            //统计a的个数
            del += 'b' - c;
        }
        int ans = del;
        for (char c : array) {
            del += (c - 'a') * 2 - 1;
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
