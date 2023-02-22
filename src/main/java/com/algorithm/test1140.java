package com.algorithm;

public class test1140 {
    public int stoneGameII(int[] piles) {
        int len=piles.length,sum=0;
        int[][]dp=new int[len][len+1];
        for(int i=len-1;i>=0;i--){
            sum+=piles[i];
            for (int m=1;m<=len;m++){
                if (i+2*m>=len){
                    //全取完
                    dp[i][m]=sum;
                }else {
                    //取最多
                    for (int x=1;x<=2*m;x++){
                      dp[i][m]=Math.max(dp[i][m],sum-dp[i+x][Math.max(m,x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
