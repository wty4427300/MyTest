package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class tes961 {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int num:nums){
            boolean result = set.add(num);
            if (!result){
                return num;
            }
        }
        return 0;
    }
}
