package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test1805 {
    public int numDifferentIntegers(String word) {
        int n = word.length();
        Set<String> set = new HashSet<>();
        for (int start = 0; start < n; start++) {
            if (Character.isDigit(word.charAt(start))) {
                int end = start;
                while (end < n && Character.isDigit(word.charAt(end))) {
                    end++;
                }
                while (start < end && word.charAt(start) == '0') {
                    start++;
                }
                set.add(word.substring(start, end));
                start = end;
            }
        }
        return set.size();
    }
}
