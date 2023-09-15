package com.algorithm;

public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int x = operation[0], y = operation[1];
            int num = gem[x] / 2;
            gem[x] -= num;
            gem[y] += num;
        }
        int min = gem[0], max = gem[0];
        for (int num : gem) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return max - min;
    }
}
