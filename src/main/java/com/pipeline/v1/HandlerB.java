package com.pipeline.v1;

public class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("扣减库存");
        return handled;
    }
}