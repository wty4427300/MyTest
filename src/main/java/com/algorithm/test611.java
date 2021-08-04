package com.algorithm;

import java.util.Arrays;

public class test611 {

    public int triangleNumber(int[] nums){
        int n=nums.length;
        //升序排序
        Arrays.sort(nums);
        int ans=0;
        //
        for (int i=0;i<n;i++){
            int k=0;
            for(int j=i+1;j<n;j++){
                //任意两边和大于第三边,并得到符合情况的最大的索引k，且nums[k]为符合情况的最大值。
                //此时i的值是固定的,k一定大于j即k-j>0,那么不符合的情况就是k-j<=0;
                while (k+1<n && nums[k+1]<nums[i]+nums[j]){
                    k++;
                }
                //此时将i递增的每个符合的情况都累加起来就得到了最终结果
                ans+=Math.max(k-j,0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a={2,3,4,5,6,7,8,9,10};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
