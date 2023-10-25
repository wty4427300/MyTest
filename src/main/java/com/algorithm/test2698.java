package com.algorithm;

public class test2698 {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    private boolean check(int t, int x) {
        if (t == x) {
            return true;
        }
        int d=10;
        while (t>=d && t%d<=x){
            if (check(t/d,x-(t%d))){
                return true;
            }
            d*=10;
        }
        return false;
    }
}
