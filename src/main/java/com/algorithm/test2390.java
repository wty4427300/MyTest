package com.algorithm;

public class test2390 {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        for (Character c:s.toCharArray()){
            if (c=='*'){
                sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test2390 test2390=new test2390();
        System.out.println(test2390.removeStars("leet**cod*e"));
        System.out.println(test2390.removeStars("erase*****"));
    }
}
