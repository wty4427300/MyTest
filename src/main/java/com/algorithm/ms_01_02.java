package com.algorithm;

public class ms_01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int s = s2.charAt(i) - 'a';
            table[s]--;
            if (table[s] < 0) {
                return false;
            }
        }
        return true;
    }
}
