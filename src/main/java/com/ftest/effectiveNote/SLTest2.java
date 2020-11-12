package com.ftest.effectiveNote;

public class SLTest2 {
    private static final SLTest2 sl=new SLTest2();
    private SLTest2(){};
    public static SLTest2 getInstance(){
        return sl;
    }

    public static void main(String[] args) {
        SLTest2 instance = SLTest2.getInstance();
    }
}
