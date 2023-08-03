package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test722 {
    private final int exist = 0;

    public List<String> removeComments(String[] source) {
        List<String> res=new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean isBlank=false;
        for (String s:source){
            for (int i = 0; i < s.length(); i++) {
                if (isBlank){
                    if (i + 1<s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        isBlank = false;
                        i++;
                    }
                }else {
                    if (i + 1<s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        isBlank = true;
                        i++;
                    } else if (i + 1<s.length() &&s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        builder.append(s.charAt(i));
                    }
                }
            }
            if (!isBlank && !builder.isEmpty()){
                res.add(builder.toString());
                builder.setLength(0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] source = new String[]{"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        test722 test722 = new test722();
        List<String> strings = test722.removeComments(source);
        System.out.println(strings);
    }
}
