package com.algorithm;

public class test1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        boolean[] has = new boolean[mx + 1];
        int ans=0,s=0,left=0;
        
        return 0;
    }
}
