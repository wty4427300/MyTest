package com.algorithm;

public class test2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //切点
                if (i == j || i + j + 1 == n) {
                    if (grid[i][j] == 0) return false;
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
