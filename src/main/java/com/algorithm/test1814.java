package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test1814 {
    public int countNicePairs(int[] nums) {
        final int mod = 1000000007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int rev = 0;
            for (int t = i; t != 0; t /= 10) {
                rev = rev * 10 + t % 10;
            }
            //f(i)
            int fi = i - rev;
            res = (res + map.getOrDefault(fi, 0)) % mod;
            map.put(fi, map.getOrDefault(fi, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        test1814 test1814 = new test1814();
        int[] nums = new int[]{42, 11, 1, 97};
        int i = test1814.countNicePairs(nums);
        System.out.println(i);
    }
}
