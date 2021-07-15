package com.ftest.designpattern;

public class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("憨批");
        return handled;
    }
}