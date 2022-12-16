package com.algorithm;

public class test1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }
}
