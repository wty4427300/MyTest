package com.algorithm;

import java.util.Arrays;

public class test2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++){
            res=Math.min(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}
