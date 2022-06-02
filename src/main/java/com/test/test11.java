package com.test;

public class test11 {
    public static void main(String[] args) {
        String a="etshdbfy    ";
        String exchangeCode = a.trim().replaceAll(" ","");
        //如果末尾有$符号则删除
        int length = exchangeCode.length();
        String lastCharacter = exchangeCode.substring(length - 1, length);
        if (lastCharacter.equals("$")){
            exchangeCode=exchangeCode.substring(0,length-1);
        }
        System.out.println(exchangeCode);
    }
}
