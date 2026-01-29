package com.algorithm;

import java.util.Arrays;

public class test2976 {
    private static final int INF = Integer.MAX_VALUE / 2;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] g = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }

        int m = original.length;
        //便利两个数据不断更新同一改变对的最小成本
        for(int i=0;i<m;i++){
            int idx = original[i]-'a';
            int idy = changed[i]-'a';
            g[idx][idy]= Math.min(g[idx][idy], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (g[i][k] != INF && g[k][j] != INF) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
        }

        int n = source.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int idx = source.charAt(i) - 'a';
            int idy = target.charAt(i) - 'a';
            if (g[idx][idy] == INF) {
                return -1;
            }
            ans += g[idx][idy];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
