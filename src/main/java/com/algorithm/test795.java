package com.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class test795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n=nums.length,ans=0;
        for(int i=0,j=-1,k=-1;i<n;i++){
            if (nums[i]>right){
                k=i;
            }else {
                if (nums[i]<left){
                    if (j>k){
                        ans+=j-k;
                    }
                }else {
                    ans+=i-k;
                    j=i;
                }
            }
        }
        return ans;
    }
}
