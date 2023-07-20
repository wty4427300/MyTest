package com.concurrent.mythread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //我的线程池的测试
        MyThreadPool myThreadPool=new MyThreadPool(10,10);
        myThreadPool.submit(() -> System.out.println("快乐就完事了"));
        myThreadPool.shutDown();
    }
}
