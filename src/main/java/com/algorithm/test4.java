package com.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num=nums1.length+nums2.length;
        int[] merge=new int[num];
        int count=0;
        while (num!=count){
            if (nums1.length>0){
                for (int i=0;i<nums1.length;i++){
                    merge[i]=nums1[i];
                    count++;
                }
            }
            if (nums2.length>0){
                for (int j=0;j<nums2.length;j++) {
                    merge[j+nums1.length] = nums2[j];
                    count++;
                }
            }
        }
        List<Integer> integers = Arrays.stream(merge).boxed().sorted().collect(Collectors.toList());
        if (integers.size()%2==0){
            return (integers.get(num/2)+integers.get(num/2-1))/2.0;
        }else {
            return (integers.get(num/2));
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        //处理只有单数组的情况
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0;
            }
            return nums2[len2 / 2];
        }

        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0;
            }
            return nums1[len1 / 2];
        }
        //合并数组
        int count = 0;
        int i = 0; //len1
        int j = 0; //len2
        //数组合并
        while (count != (len1 + len2)) {
            if (i == len1) {
                while (j != len2) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == len2) {
                while (i != len1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        //获取奇数和偶数的中位数字
        if (count % 2 == 0) {
            return (nums[count / 2 -1] + nums[count / 2]) / 2.0;
        }
        return nums[count / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays2(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
