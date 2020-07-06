package com.ftest.MyThread;

public class MyRunnable implements Runnable{
    private Object param;

    public  MyRunnable(Object param){
        this.param=param;
    }

    @Override
    public void run() {
        System.out.println(param.toString());
    }
}
