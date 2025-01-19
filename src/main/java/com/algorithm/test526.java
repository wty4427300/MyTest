package com.algorithm;

import java.util.Arrays;

public class test526 {
    public int countArrangement(int n) {
        //每个数有选或不选两种可能所以吗，全部的情况就是2^n
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        return dfs(0, n, memo);
    }

    /**
     * 递归搜索 + 保存递归返回值 = 记忆化搜索
     */
    private int dfs(int s, int n, int[] memo) {
        //有效排序，返回1
        if (s == (1 << n) - 1) {
            return 1;
        }
        //已经计算过了，直接返回
        if (memo[s] != -1) {
            return memo[s];
        }
        int res = 0;
        //bitCount统计二进制s中有几个1
        int i = Integer.bitCount(s) + 1;
        for (int j = 1; j <= n; j++) {
            //判断该位置没有被使用并且是一个优美排序
            if ((s >> (j - 1) & 1) == 0 && (i % j == 0 || j % i == 0)) {
                //更新新的优美排序位置，继续递归下一个位置
                res += dfs(s | (1 << (j - 1)), n, memo);
            }
        }
        //保存当前结果
        memo[s] = res;
        return res;
    }

    public static void main(String[] args) {
        test526 test526 = new test526();
        int i = test526.countArrangement(2);
        System.out.println(i);
    }
}
