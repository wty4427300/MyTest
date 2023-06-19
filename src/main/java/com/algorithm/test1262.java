package com.algorithm;

public class test1262 {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[] remainder=new int[3];
        for (int i=0;i<n;i++){
            int a,b,c;
            a = remainder[0] + nums[i];
            b = remainder[1] + nums[i];
            c = remainder[2] + nums[i];
            remainder[a%3] = Math.max(remainder[a%3], a);
            remainder[b%3] = Math.max(remainder[b%3], b);
            remainder[c%3] = Math.max(remainder[c%3], c);
        }
        return remainder[0];
    }
}
