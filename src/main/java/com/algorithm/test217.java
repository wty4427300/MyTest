package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class test217 {

    //排序之后，相等的数必定前后相邻
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
               if (nums[i]==nums[i+1]){
                   return true;
               }
        }
        return false;
    }

    //简单的去重策略
    public boolean containsDuplicate_1(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add){
                return true;
            }
        }
        return false;
    }
}
