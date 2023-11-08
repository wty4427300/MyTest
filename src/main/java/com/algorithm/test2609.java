package com.algorithm;

public class test2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length(), idx = 0, ans = 0;
        while (idx < n) {
            int a = 0, b = 0;
            while (idx < n && s.charAt(idx) == '0' && a++ >= 0) {
                idx++;
            }
            while (idx < n && s.charAt(idx) == '1' && ++b >= 0) {
                idx++;
            }
            ans = Math.max(ans, Math.min(a, b) * 2);
        }
        return ans;
    }
}
