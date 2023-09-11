package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int i=this.same(nums1,nums2);
        if (i!=-1){
            return i;
        }
        int x=Arrays.stream(nums1).min().getAsInt();
        int y=Arrays.stream(nums2).min().getAsInt();
        return Math.min(x*10+y,y*10+x);
    }

    public int same(int[] nums1, int[] nums2) {
        Set<Integer> s=new HashSet<>();
        for (int i:nums1){
            s.add(i);
        }
        int x=10;
        for (int i:nums2){
            if (s.contains(i)){
                x=Math.min(x,i);
            }
        }
        return x==10?-1:x;
    }
}
