package com.algorithm;

public class test3184 {
    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for (int i = 1; i < hours.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
