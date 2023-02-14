package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int s = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
        test1124 test1124 = new test1124();
        int i = test1124.longestWPI(hours);
        System.out.println(i);
    }
}
