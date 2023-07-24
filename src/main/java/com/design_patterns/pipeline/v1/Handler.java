package com.design_patterns.pipeline.v1;

public abstract class Handler {
    /**
     * 后继处理方法
     */
    private Handler successor=null;

    /**
     * 抽象方法后续会有具体实现
     */
    protected abstract boolean doHandle();

    public void setSuccessor(Handler successor){
        this.successor=successor;
    }

    public final void handle(){
        //执行当前handle类的doHandle()
        boolean handled=doHandle();
        //判断是否继续执行下一个节点
        if (successor!=null&&!handled){
            successor.handle();
        }
    }
}

