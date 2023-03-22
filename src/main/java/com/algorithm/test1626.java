package com.algorithm;

import java.util.Arrays;

public class test1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] plays = new int[n][2];
        for (int i = 0; i < n; i++) {
            plays[i][0] = ages[i];
            plays[i][1] = scores[i];
        }
        //按照年龄升序排序，年龄相同时按照分数升序排序
        Arrays.sort(plays, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //dp[i] 表示以第 i 个球员为结尾的最大得分
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = plays[i][1];
            //年龄小于等于
            for (int j = 0; j < i; j++) {
                if (plays[j][1] <= plays[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + plays[i][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
