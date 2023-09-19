package com.algorithm;

public class test34 {
    public int lowerBounds(int[] nums, int target) {
        //[l,r]
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int lowerBounds1(int[] nums, int target) {
        //[l,r)
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;  //return l或者r都可以
    }

    public int lowerBounds2(int[] nums, int target) {
        //(l,r)
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public int[] searchRange(int[] nums, int target) {
        int start=lowerBounds(nums,target);
        if (start==nums.length || nums[start]!=target){
            return new int[]{-1,-1};
        }
        int end=lowerBounds(nums,target+1)-1;
        return new int[]{start,end};
    }
}
