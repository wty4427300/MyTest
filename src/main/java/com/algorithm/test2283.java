package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test2283 {
    public boolean digitCount(String num) {
        int[] nums = new int[10];
        for (int i = 0; i < num.length(); i++) {
            nums[num.charAt(i) - '0'] += 1;
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != nums[i])
                return false;
        }
        return true;
    }
}
