package com.algorithm;

public class test793 {

    public int preimageSizeFZF(int k) {
        if (k <= 1) {
            return 5;
        }
        return this.f(k) - this.f(k - 1);
    }

    public int f(int k) {
        long l = 0, r = (long) 1e10;
        //二分
        while (l < r) {
            //右移1等于除于2
            long mid = l + r + 1 >> 1;
            if (this.getCnt(mid) <= k) {
                l = mid;
            }else {
                r=mid-1;
            }
        }
        return (int) r;
    }

    public long getCnt(long x) {
        long ans = 0;
        while (x != 0) {
            ans += x / 5;
            x /= 5;
        }
        return ans;
    }
}
