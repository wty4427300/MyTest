package com.algorithm;

public class test2485 {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if ((1 + i) * i == (i + n) * (n - i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
