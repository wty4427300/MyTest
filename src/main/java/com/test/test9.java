package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test9 {
    public static void main(String[] args) {
        String a="";
        System.out.println("[");
        Arrays.stream(a.split("\n")).forEach(
                it->{
                    System.out.println("\""+it+"\""+",");
                }
        );
        System.out.println("]");
        Map<String,String> map=new HashMap<>();
    }
}
