package com.algorithm;

public class test1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        //转成整数
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        String res = sb.toString();
        for (int i = 1; i <=k && res.length() > 1; i++) {
            int sum = 0;
            for (int j = 0; j < res.length(); j++) {
                sum += res.charAt(j) - '0';
            }
            res = Integer.toString(sum);
        }
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        test1945 test1945=new test1945();
        int sum = test1945.getLucky("iiii", 1);
        System.out.println(sum);
    }
}
