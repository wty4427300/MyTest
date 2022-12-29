package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums1){
            map.put(i,1);
        }
        for (int i:nums2){
            map.put(i,map.getOrDefault(i, 0)|2);
        }
        for (int i:nums3){
            map.put(i,map.getOrDefault(i, 0)|4);
        }
        List<Integer> result=new ArrayList<>();
        map.forEach(
                (k,v)->{
                    //最右边的1变为0
                    if ((v & (v - 1))!=0){
                        result.add(k);
                    }
                }
        );
        return result;
    }
}
