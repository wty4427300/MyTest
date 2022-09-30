package com.algorithm;

public class ms_01_08 {
    public void setZeroes(int[][] matrix) {
        //求矩阵的长宽
        int m = matrix.length, n = matrix[0].length;
        //两个数组做标记
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    //标记0
                    row[i]=col[j]=true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr=new int[3][2];
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    arr[i][j]=0;
                }else {
                    arr[i][j]=1;
                }
            }
        }
        ms_01_08 mx=new ms_01_08();
        mx.setZeroes(arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
