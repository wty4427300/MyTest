package com.ftest.myMath;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(or(1,1));
        System.out.println(and(1,1));
        System.out.println(xor(1,1));
    }
    public static int or(int a,int b){
        return a|b;
    }
    public static int and(int a,int b){
        return a&b;
    }
    public static int xor(int a,int b){
        return  a^b;
    }
}
