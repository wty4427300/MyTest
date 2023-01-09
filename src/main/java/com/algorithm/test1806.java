package com.algorithm;

import java.util.Arrays;

public class test1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int count = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0) {
                    //奇数
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    //偶数
                    arr[i] = perm[i / 2];
                }
            }
            perm = arr;
            count++;
            if (Arrays.equals(perm, target)) {
                break;
            }
        }
        return count;
    }
}