package com.ftest.effectiveNote;

public class MyUtil {

    /**
     * 防止内部调用所以直接抛出异常就好
     */
    private MyUtil() {
        throw new AssertionError();
    }

    public static String toString(int i){
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        MyUtil myUtil=new MyUtil();
    }
}
