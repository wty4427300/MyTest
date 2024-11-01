package com.algorithm;

public class test3259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] d = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            //第一个取A
            d[i][0] = d[i - 1][0] + energyDrinkA[i - 1];
            //第一个取B
            d[i][1] = d[i - 1][1] + energyDrinkB[i - 1];
            //从第三个开始
            if (i >= 2) {
                d[i][0] = Math.max(d[i][0], d[i - 2][1] + energyDrinkA[i - 1]);
                d[i][1] = Math.max(d[i][1], d[i - 2][0] + energyDrinkB[i - 1]);
            }
        }
        return Math.max(d[n][0], d[n][1]);
    }
}
