package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class test2395 {
    public boolean findSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<n-1;i++){
            int sum=nums[i]+nums[i+1];
            if (!set.add(sum)){
                return true;
            }
        }
        return false;
    }
}
