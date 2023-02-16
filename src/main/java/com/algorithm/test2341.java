package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for (int num:nums){
            map.put(num,!map.getOrDefault(num,false));
            if (!map.get(num)){
                res++;
            }
        }
        return new int[]{res,nums.length-2*res};
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,1,3,2,2};
        test2341 test2341=new test2341();
        int[] ints = test2341.numberOfPairs(nums);
        System.out.println(Arrays.toString(ints));
    }
}
