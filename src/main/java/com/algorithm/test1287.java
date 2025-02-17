package com.algorithm;

public class test1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int cur = arr[0];
        int count = 0;
        for (int j : arr) {
            if (j == cur) {
                count++;
                if (count * 4 > n) {
                    return cur;
                }
            } else {
                cur = j;
                count = 1;
            }
        }
        return -1;
    }
}
