package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1175 {
    static int mod = (int) 1e9 + 7;
    static List<Integer> list = new ArrayList<>();

    //质数是大于1的，所以从2开始
    //100以内的质数
    static {
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = false;
                }
            }
            if (ok) {
                list.add(i);
            }
        }
    }

    public int numPrimeArrangements(int n) {
        int l = 0, r = list.size() - 1;
        //二分求质数范围
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid) <= n){
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int a = r + 1, b = n - a;
        long ans = 1;
        for (int i = b; i > 1; i--) {
            ans = ans * i % mod ;
        }
        for (int i = a; i > 1; i--) {
            ans = ans * i % mod ;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int r = 0;
        int mid = 1 + r + 1 >> 1;
        System.out.println(mid);
    }
}
