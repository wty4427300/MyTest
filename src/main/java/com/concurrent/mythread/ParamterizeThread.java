package com.concurrent.mythread;

//这个接口继承了runnable接口所以他可以作为线程的实际逻辑跑起来
public class ParamterizeThread<T> implements Runnable {
    //这个类需要两个成员变量
    private  T context;
    //消息
    private  ParamterizeThreadStart paramterizeThreadStart;
    //接口
    public  ParamterizeThread(T context,ParamterizeThreadStart paramterizeThreadStart){
        this.context=context;
        this.paramterizeThreadStart=paramterizeThreadStart;
    }
    //构造函数,为两个成员变量赋值



    public  T getContext(){
        return context;
    }
    //获取消息
    @Override
    public void run() {
        paramterizeThreadStart.run(context);
    }
    //实现接口的方法
}
