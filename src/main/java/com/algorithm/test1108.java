package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1108 {
    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        StringBuffer stringBuffer=new StringBuffer();
        for (char c:chars){
            if (c=='.'){
                stringBuffer.append('[');
                stringBuffer.append('.');
                stringBuffer.append(']');
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        test1108 test1108=new test1108();
        String address = "1.1.1.1";
        String s = test1108.defangIPaddr(address);
        System.out.println(s);
    }
}
