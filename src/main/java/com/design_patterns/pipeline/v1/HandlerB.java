package com.design_patterns.pipeline.v1;

public class HandlerB extends AbstractHandler<String> {
    @Override
    protected boolean doHandle(String context) {
        boolean handled=false;
        System.out.println(context);
        return handled;
    }
}