package com.algorithm;

public class test788 {
    public int rotatedDigits(int n) {
        int ans = 0;
        loop:
        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            int x = i;
            while (x != 0) {
                int t = x % 10;
                x /= 10;
                if (t == 2 || t == 5 || t == 6 || t == 9) {
                    ok = true;
                } else if (t != 0 && t != 1 && t != 8) {
                    continue loop;
                }
            }
            if (ok) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=10;
        test788 test788=new test788();
        test788.rotatedDigits(n);
    }
}
