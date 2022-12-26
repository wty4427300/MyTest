package com.algorithm;

public class test1759 {
    public int countHomogenous(String s) {
        final int mod = 1000000007;
        long res = 0;
        char prev = s.charAt(0);
        int cnt = 0;
        //一遍遍历统计相同字符的字符串长度
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                cnt++;
            } else {
                //等差数列和
                res += (long) (cnt + 1) * cnt / 2;
                cnt = 1;
                prev = c;
            }
        }
        //加上最后一个同构字符子串
        res += (long) (cnt + 1) * cnt / 2;
        return (int) (res % mod);
    }
}
