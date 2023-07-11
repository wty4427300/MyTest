package com.algorithm;

public class test2490 {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        char start = s[0].charAt(0);
        char end = s[s.length - 1].charAt(s[s.length - 1].length() - 1);
        for (int i = 0; i <= s.length - 2; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }
        }
        return start==end;
    }

    public static void main(String[] args) {
        String str="ab a";
        test2490 test2490=new test2490();
        boolean sentence = test2490.isCircularSentence(str);
        System.out.println(sentence);
    }
}
