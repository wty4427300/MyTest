package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class test646 {
    public int findLongestChain(int[][] pairs) {
        int cur=Integer.MIN_VALUE, res=0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] a:pairs){
            //b<c
            if(cur<a[0]){
                cur=a[1];
                res++;
            }
        }
        return res;
    }
}
