package com.design_patterns.pipeline.v1;

public abstract class AbstractHandler<T> {
    /**
     * 后继处理方法
     */
    private AbstractHandler next = null;

    /**
     * 抽象方法后续会有具体实现
     */
    protected abstract boolean doHandle(T context);

    public void setSuccessor(AbstractHandler<T> next) {
        this.next = next;
    }

    public final void handle(T context) {
        //执行当前handle类的doHandle()
        boolean handled = doHandle(context);
        //判断是否继续执行下一个节点
        if (next != null && !handled) {
            next.handle(context);
        }
    }
}

