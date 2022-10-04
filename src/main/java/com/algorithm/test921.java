package com.algorithm;

import java.util.Objects;

public class test921 {
    public int minAddToMakeValid(String s) {
        if (Objects.equals(s, "")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int a=0,b=0;
        for (char c:chars){
            if (c=='('){
                a++;
            }else {
                if (a>0){
                    a--;
                }else {
                    b++;
                }
            }
        }
        return a+b;
    }
}
