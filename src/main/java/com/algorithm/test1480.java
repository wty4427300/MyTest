package com.algorithm;

public class test1480 {
    public int[] runningSum(int[] nums) {
        int[] ans=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int tmp=0;
            for (int j=0;j<i;j++){
                  tmp+=nums[j];
            }
            ans[i]=tmp;
        }
        return ans;
    }
}
