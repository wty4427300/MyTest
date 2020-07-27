package com.ftest.test;


public class Dynamic {
    /**
     * 动规买股票
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 第一天不卖出，只买入，所以卖出收益为0
        dp[0][0] = 0;
        //第一天的买入收益就是买入价格本身
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //第i天卖出的最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第i天买入的最大收益
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * @param n
     * @return
     * 动规爬楼梯
     */
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
