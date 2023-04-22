package com.algorithm;

public class test1027 {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        int[][] f=new int[n][1001];
        for (int i=1;i<n;i++){
            for(int k=0;k<i;k++){
                //枚举公差j
                int j=nums[i]-nums[k]+500;
                f[i][j]=Math.max(f[i][j],f[k][j]+1);
                ans=Math.max(ans,f[i][j]);
            }
        }
        return ans+1;
    }
}
