package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //从小到大，值以及对应的index
            map.put(arr[i], i);
        }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            //因为我们要的到最长的数列，当j位于倒数第二位的时候我们可以的到理论上的最大数列
            for (int j = i - 1; j >= 0 && j + 2 > ans; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    //存在t，但不满足t<j<i挺
                    break;
                }
                int t = map.getOrDefault(arr[i] - arr[j], -1);
                if (t == -1) {
                    //t不在数列里
                    continue;
                }
                //当t<j<i成立就有最少是3个元素的数列，之后每成功一次数列长度+1
                f[i][j] = Math.max(3, f[j][t] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test873 test873 = new test873();
        //1,2,3,5,8
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        test873.lenLongestFibSubseq(arr);
    }
}
