package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class test870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //索引数组
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        //根据元素的大小排序索引
        Arrays.sort(idx1, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(idx2, Comparator.comparingInt(i -> nums2[i]));
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            //首元素比较
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

    public int[] advantageCount1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //nums2索引
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(nums1);
        //根据nums2数据升序，排序nums2(索引)
        //注释的这段代码更快应该是少一层方法栈的原因
        //Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]);
        Arrays.sort(idx, Comparator.comparingInt(i -> nums2[i]));
        // nums2(索引)的左右指针
        int l = 0, r = n - 1;
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[idx[l]]) {
                //可以满足 nums1[i] > nums2[i]
                nums2[idx[l++]] = i;
            } else {
                //丢到数组最后
                nums2[idx[r--]] = i;
            }
        }
        return nums2;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{1, 10, 4, 11};
        test870 test870 = new test870();
        test870.advantageCount(nums1, nums2);
    }
}
