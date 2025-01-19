package com.algorithm;

import java.util.Arrays;

public class test3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int m=grid[0].length;
        int[] col=new int[m];
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                col[j] += ints[j];
            }
        }
        long res=0;
        for (int[] ints : grid) {
            int row = Arrays.stream(ints).sum();
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    res += (long) (row - 1) * (col[j] - 1);
                }
            }
        }
        return res;
    }
}
