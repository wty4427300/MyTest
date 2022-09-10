package com.algorithm;

public class test1582 {
    public int numSpecial(int[][] mat) {
        //得到二维矩阵的长宽
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i]+=mat[i][j];
                c[j]+=mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
