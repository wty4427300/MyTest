package com.algorithm;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num=nums1.length+nums2.length;
        int[] merge=new int[num];
        for (int i=0;i<nums1.length;i++){
            merge[i]=nums1[i];
        }
        for (int j=nums1.length-1;j<num;j++){
            merge[j]=nums2[j];
        }
//        Arrays.stream(merge).colle
//        Collections.sort(Arrays.asList(mcerge));
        return 0.0;
    }
}
