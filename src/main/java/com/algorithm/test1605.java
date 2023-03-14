package com.algorithm;

import java.util.Arrays;

public class test1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length;
        int c = colSum.length;
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j]=Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=matrix[i][j];
                colSum[j]-=matrix[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] row=new int[]{3,8};
        int[] col=new int[]{4,7};
        test1605 test1605=new test1605();
        int[][] ints = test1605.restoreMatrix(row, col);
        System.out.println(Arrays.deepToString(ints));
    }
}
