package com.ftest.Leetcode;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length-k];
    }

    private void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int p, int r){
        if(p>=r){
            return;
        }
        int q=partition(nums,p,r);
        quickSort(nums,p,q-1);
        quickSort(nums,q+1,r);
    }

    private int partition(int[] nums, int p, int r){
        //使用数组尾为分区点
        int pivot=nums[r];
        //开始循环遍历
        int i=p;

        for(int j=p;j<r;j++){
            if(nums[j]<pivot){
                if(i==j){
                    ++i;
                }else{
                    swap(nums,i,j);
                }
            }
        }
        //将分区点和nums[i]交换
        swap(nums,i,r);
        return i;
    }
    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}