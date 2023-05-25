package com.test;

/**
 * 一个关于矩阵旋转的例子
 */
public class Solution {
    public static void rotate(int[][] matrix) {
        int temp;
        for (int x = 0, y = matrix[0].length - 1; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                temp = matrix[x][s];
                System.out.println("temp:" + temp + "\t" + "x:" + x + "\t" + "s:" + s);
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //2*2的二维数组
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(a);
        System.out.println(a[0][0]);
    }
}
