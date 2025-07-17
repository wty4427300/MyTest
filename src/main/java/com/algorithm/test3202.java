package com.algorithm;

public class test3202 {

    public int maximumLength(int[] nums, int k) {
        // dp[p][r] 表示以 ...p, r 结尾的交替余数子序列的最大长度
        int[][] dp = new int[k][k];
        int maxLength = 0;

        for (int num : nums) {
            int r = num % k;
            for (int p = 0; p < k; p++) {
                // 我们找到了一个数字，其余数为 r
                // 它可以接在一个以 p 结尾的序列后面，形成 ...p, r 的新序列
                // 这个 ...p 序列的前一个元素余数必须是 r
                // 所以我们实际上是扩展了一个以 (r, p) 结尾的序列
                // 新序列的长度是 dp[r][p] + 1
                dp[p][r] = dp[r][p] + 1;
                maxLength = Math.max(maxLength, dp[p][r]);
            }
        }
        return maxLength;
    }
}