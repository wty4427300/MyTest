package com.algorithm;

public class test1417 {

    public String reformat(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断该字符是不是数字
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        //计算字母长度
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        boolean flag = sumDigit > sumAlpha;
        char[] arr = s.toCharArray();
        //i是偶数位,j是奇数位
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            //数量多的始终放在偶数位
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                this.swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
