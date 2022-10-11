package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                index.add(i);
            }
        }
        if (index.isEmpty()) {
            return true;
        }
        if (index.size() != 2) {
            return false;
        }
        return a[index.get(0)] == b[index.get(1)] && a[index.get(1)] == b[index.get(0)];
    }
}
