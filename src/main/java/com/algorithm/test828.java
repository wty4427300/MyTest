package com.algorithm;

import java.util.Arrays;

public class test828 {
    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        int[] cnts = new int[26];
        Arrays.fill(cnts, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = cnts[u];
            cnts[u] = i;
        }
        Arrays.fill(cnts, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = cnts[u];
            cnts[u] = i;
        }
        for (int i = 0; i < n; i++){
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        test828 test828 = new test828();
        int res = test828.uniqueLetterString("ABA");
        System.out.println(res);
    }
}
