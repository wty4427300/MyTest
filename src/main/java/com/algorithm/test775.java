package com.algorithm;

public class test775 {
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length,minsuff=nums[n-1];
        for (int i=n-3;i>=0;i--){
            if (nums[i]>minsuff){
                return false;
            }
            minsuff=Math.min(minsuff,nums[i+1]);
        }
        return true;
    }
}
