package com.ftest.myParser;

/**
 * @author wty
 */
public class SimpleYacc {
    public static void main(String[] args) {
        prt("shabi");
    }

    public static void prt(String str){
        System.out.println(str);
    }
    public static int pos(char[] str){
        return str.length;
    }
}
