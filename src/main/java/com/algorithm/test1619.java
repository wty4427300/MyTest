package com.algorithm;

import java.util.Arrays;

public class test1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = 0;
        //计算除去5%后的数组范围
        for (int i = n / 20; i < n - n / 20; i++) {
            tot += arr[i];
        }
        //一共减去10%还剩90%
        return tot * 1.0 / (n * 0.9);
    }
}
