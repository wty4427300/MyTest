package com.algorithm;

public class test915 {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        //统计[i,n-1]范围内的最小值
        int[] min=new int[n+10];
        min[n-1]=nums[n-1];
        for (int i=n-2;i>=0;i--){
            min[i]=Math.min(min[i+1],nums[i]);
        }
        //left数组的最大值小于right的最小值则条件成立
        for (int i=0,max=0;i<n-1;i++){
            max=Math.max(max,nums[i]);
            if (max<=min[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}
