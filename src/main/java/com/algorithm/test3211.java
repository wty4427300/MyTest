package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test3211 {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        int mask = (1 << n) - 1;
        for (int i = 0; i < 1 << n; i++) {
            //取反
            int t = mask ^ i;
            //判断有无相邻的1
            if (((t >> 1) & t) == 0) {
                String str = Integer.toBinaryString(i);
                String sb = "0".repeat(Math.max(0, n - str.length())) +
                        str;
                res.add(sb);
            }
        }
        return res;
    }
}
