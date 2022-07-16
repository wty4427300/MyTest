package com.algorithm;

public class test_02_41 {

    static class MovingAverage {
        int arr[] = new int[10 * 10 * 10 * 10];
        int n, sum, j, i;

        //初始化滑动窗口大小;
        public MovingAverage(int size) {
            n = size;
        }

        public double next(int val) {
            sum += arr[i++] = val;
            if (i - j > n) {
                sum -= arr[j++];
            }
            //总和除以窗口大小
            return sum * 1.0 / (i - j);
        }
    }

}
