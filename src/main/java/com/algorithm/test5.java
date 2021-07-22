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
    public static String longestPalindrome1(String s) {
        //当长度为1的时候直接返回
        if (s.length() == 1) return s;
        //添加占位符
        char[] chars = manacherString(s);
        int n = chars.length;
        int[] pArr = new int[n];
        int C = -1, R = -1, pos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pArr[i] = i < R ? Math.min(pArr[C * 2 - i], R - i) : 1;
            while (i + pArr[i] < n && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                pos = i;
            }
        }
        int offset = pArr[pos];
        StringBuilder sb = new StringBuilder();
        for (int i = pos - offset + 1; i <= pos + offset - 1; i++) {
            if (chars[i] != '#') sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 添加占位符
     */
    public static char[] manacherString(String s) {
        //len*2+1=补充了占位符的长度
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0, idx = 0; i < chars.length; i++) {
            //如果是奇数补充占位符
            chars[i] = (i & 1) == 0 ? '#' : s.charAt(idx++);
        }
        return chars;
    }


    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        String s = "babad";
//        String longestPalindrome = longestPalindrome(s);
//        System.out.println(longestPalindrome);
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1-l);
//        String substring = s.substring(1, 1);
//        System.out.println(substring);
//        char c = s.charAt(0);
//        System.out.println(c);
//        char c1 = s.charAt(2);
//        System.out.println(c1);
        String a="2";
        System.out.println(manacherString(a));
    }
}
