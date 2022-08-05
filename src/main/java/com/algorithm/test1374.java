package com.algorithm;

import java.util.Arrays;

public class test1374 {

    /**
     * 奇数减1就是偶数
     */
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n % 2 == 1) {
            //奇数
            while (n-- > 0) {
                stringBuilder.append("a");
            }
        } else {
            //偶数
            while (n-- > 0) {
                if (n == 0) {
                    stringBuilder.append("b");
                } else {
                    stringBuilder.append("a");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        test1374 test1374 = new test1374();
        String result = test1374.generateTheString(4);
        System.out.println(result);
    }
}
