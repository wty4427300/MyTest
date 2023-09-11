package com.algorithm;

public class test2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = (long) ranks[0] * cars * cars;
        while (left < right) {
            long mid = (left + right) >> 1;
            long cnt = 0;
            for (int r : ranks) {
                cnt += (long) Math.sqrt((double) mid / r);
            }
            if (cnt >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
