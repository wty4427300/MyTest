package com.ftest.designpattern;

public class HandlerA extends Handler{

    @Override
    protected boolean doHandle() {
        boolean handled=false;
        System.out.println("傻逼");
        return handled;
    }
}
