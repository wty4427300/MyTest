package com.algorithm;

public class test1995 {

    public int countQuadruplets(int[] nums) {
        int n=nums.length,ans=0;
        int[] cnt=new int[10010];
        //这时枚举c的位置,c的倒序的初始的index=length-2
        //c>=2是c的最后一个位置
        for (int c=n-2;c>=2;c--){
            //开始打表d,每次出现对应的位置记录+1
            cnt[nums[c+1]]++;
            for (int a=0;a<n;a++){
                for (int b=a+1;b<c;b++){
                    //开始累加每个位置出现的d
                    ans+=cnt[nums[a]+nums[b]+nums[c]];
                }
            }
        }
        //返回统计后的总数
        return ans;
    }
}
