package com.algorithm;

import java.util.Arrays;

public class test2656 {
    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2*m+k-1)*k/2;
    }
}
