package com.algorithm;

public class test2379 {
    public int minimumRecolors(String blocks, int k) {
        int cnt = 0;
        //统计窗口k白块数量
        for (int i = 0; i < k; ++i) {
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
        }
        int ans = cnt;
        for (int i = k; i < blocks.length(); ++i) {
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(i - k) == 'W' ? 1 : 0;
            ans = Math.min(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        test2379 test2379=new test2379();
        int i = test2379.minimumRecolors(blocks, k);
        System.out.println(i);
    }
}
