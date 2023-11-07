package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class test2568 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (vowels.contains(w.charAt(0)) && vowels.contains(w.charAt(w.length() - 1))) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       String[] words =new String[]{"are","amy","u"};
       int left=0,right=2;
       test2568 test2568=new test2568();
        int i = test2568.vowelStrings(words, left, right);
        System.out.println(i);
    }
}
