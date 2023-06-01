package com.algorithm;

import java.util.Arrays;

public class test2517 {
    public int maximumTastiness(int[] price, int k) {
        //排序省去求绝对值的过程
        Arrays.sort(price);
        //right是差值的最大值
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness) {
        int prev = -tastiness;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        int i=Integer.MIN_VALUE;
        System.out.println(i);
    }
}
