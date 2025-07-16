package com.algorithm;

public class test3201 {
    public int maximumLength(int[] nums) {
        // 纯偶数子序列的长度
        int evenCount = 0;
        // 纯奇数子序列的长度
        int oddCount = 0;
        // 偶数开头的奇偶交替子序列的长度
        int altEvenOdd = 0;
        // 奇数开头的奇偶交替子序列的长度
        int altOddEven = 0;

        // altEvenOdd 序列下一个期望的奇偶性 (0 for even, 1 for odd)
        int nextForEvenOdd = 0;
        // altOddEven 序列下一个期望的奇偶性 (0 for even, 1 for odd)
        int nextForOddEven = 1;

        for (int num : nums) {
            int parity = num % 2;
            if (parity == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            // 检查是否匹配偶数开头的交替序列
            if (parity == nextForEvenOdd) {
                altEvenOdd++;
                nextForEvenOdd = 1 - nextForEvenOdd; // 切换期望的奇偶性
            }

            // 检查是否匹配奇数开头的交替序列
            if (parity == nextForOddEven) {
                altOddEven++;
                nextForOddEven = 1 - nextForOddEven; // 切换期望的奇偶性
            }
        }

        // 返回四种情况中的最大值
        return Math.max(Math.max(evenCount, oddCount), Math.max(altEvenOdd, altOddEven));
    }

    public int maximumLength1(int[] nums) {
        int res = 0;
        int[][] patterns = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] p : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == p[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
