package com.design_patterns.pipeline.v1;

public class HandlerChain<T> {
    private AbstractHandler<T> head = null;
    private AbstractHandler<T> tail = null;

    public void addHandler(AbstractHandler<T> handler) {
        handler.setSuccessor(null);
        //处理第一个链表节点
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(T context) {
        if (head != null) {
            head.handle(context);
        }
    }
}
