package com.algorithm;

public class test5 {
    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 回文串为奇数
            int l = i - 1, r = i + 1;
            String sub = getString(s, l, r);
            System.out.println(sub);
            if (sub.length() > ans.length()) {
                ans = sub;
            }
            // 回文串为偶数
            l = i - 1;
            r = i + 1 - 1;
            sub = getString(s, l, r);
            System.out.println(sub);
            if (sub.length() > ans.length()) {
                ans = sub;
            }
        }
        return ans;
    }
    public static String getString(String s, int l, int r) {
        //以字符串的一个字符为回文点左边和右边的字符相等就是回文串
        //也就是说当不断向两边扩展不是回文串的时候退出循环
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        System.out.println("l:"+l+","+"r:"+r);
        //因为sub是前开后闭区间所以左边需要+1去除不是回文串的字符,而右边不用
        return s.substring(l + 1, r);
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        String substring = s.substring(1, 1);
//        System.out.println(substring);
//        char c = s.charAt(0);
//        System.out.println(c);
//        char c1 = s.charAt(2);
//        System.out.println(c1);
    }
}
