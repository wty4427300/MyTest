package com.test;

public class test15 {

    public boolean isPalindrome(String s) {
        // 定义递归函数，检查首尾字符是否相同，并逐渐向中间收缩
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    public boolean isPalindromeHelper(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        //首尾不同，不是回文串
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        //继续递归判断下一个子串
        return isPalindromeHelper(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        test15 test15 = new test15();
        boolean abccba = test15.isPalindrome("abccba");
        System.out.println(abccba);
        boolean abb = test15.isPalindrome("abb");
        System.out.println(abb);
    }
}
