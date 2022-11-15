package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1704 {
    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        String a = s.substring(0, half);
        String b = s.substring(half);
        String h = "aeiouAEIOU";
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if (h.indexOf(a.charAt(i)) >= 0) {
                sum1++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (h.indexOf(b.charAt(i)) >= 0) {
                sum2++;
            }
        }
        return sum1 == sum2;
    }

}
