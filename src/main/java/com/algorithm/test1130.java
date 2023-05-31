package com.algorithm;

import java.util.Arrays;

public class test1130 {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/4);
        }
        //存储字数组的最大值
        int[][] mval=new int[n][n];
        for (int j=0;j<n;j++){
            //j就是切分字数组的位置
            mval[j][j]=arr[j];
            dp[j][j]=0;
            for (int i=j-1;i>=0;i--){
                mval[i][j]=Math.max(arr[i],mval[i+1][j]);
                for (int k=i;k>j;k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        test1130 test1130=new test1130();
        int[] arr=new int[]{1,2,3};
        test1130.mctFromLeafValues(arr);
    }
}
