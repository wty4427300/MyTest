package com.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 1) + 1);
            }
        }
        int ans = -1, mx = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            if (mx < v || (mx == v && ans > x)) {
                ans = x;
                mx = v;
            }
        }
        return ans;
    }
}
