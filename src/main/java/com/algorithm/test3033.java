package com.algorithm;

import java.util.Arrays;

public class test3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        //长
        int n = matrix.length;
        //宽
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            int zd = -1;
            for (int[] ints : matrix) {
                //取每个数组的同一列的最大值
                zd = Math.max(zd, ints[j]);
            }
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = zd;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        test3033 test3033 = new test3033();
        int[][] ints = test3033.modifiedMatrix(matrix);
        System.out.println(Arrays.deepToString(ints));
    }
}
