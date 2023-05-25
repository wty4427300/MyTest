package com.ftest.effectivenote;

/**
 * 私有构造器仅被调用一次用来初始化共有的静态域
 */
public class SLTest1 {

    public static final SLTest1 instance=new SLTest1();

    private SLTest1(){

    }
    public void leaveTheBuilding() {

    }

    public static void main(String[] args) {
        SLTest1 instance = SLTest1.instance;
    }

}
