package com.algorithm;

import java.util.Arrays;

public class test2578 {
    public int splitNum(int num) {
        char[] stnum = Integer.toString(num).toCharArray();
        Arrays.sort(stnum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stnum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stnum[i] - '0');
            } else {
                num2 = num2 * 10 + (stnum[i] - '0');
            }
        }
        return num1 +  num2;
    }

    public static void main(String[] args) {
        test2578 test2578 = new test2578();
        int num = test2578.splitNum(4325);
        System.out.println(num);
    }
}
