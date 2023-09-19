package com.algorithm;

public class test2560 {
    public int minCapability(int[] nums, int k) {
        int l=0, r=0;
        for (int x:nums){
            r=Math.max(r,x);
        }
        while (l+1<r){
            int mid=(l+r)>>>1;
            if (check(nums,k,mid)){
                r=mid;
            }else {
                l=mid;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int k,int mx){
        int f0=0,f1=0;
        for (int x:nums){
            if (x>mx){
                f0=f1;
            }else {
                int tmp=f1;
                f1=Math.max(f1,f0+1);
                f0=tmp;
            }
        }
        return f1>=k;
    }
}
