package com.design_patterns.pipeline.v1;

public class HandlerA extends Handler {

    @Override
    protected boolean doHandle() {
        boolean handled=false;
        System.out.println("初始化订单");
        return handled;
    }
}