package com.pipeline.v1;

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
        boolean handled=doHandle();
        if (successor!=null&&!handled){
            successor.handle();
        }
    }
}

