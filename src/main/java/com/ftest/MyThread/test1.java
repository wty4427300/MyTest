package com.ftest.MyThread;

import java.util.concurrent.*;

class Task implements Runnable{
    int r;
    public Task(int result) {
        this.r=result;
    }

    @Override
    public void run() {
        r=r+1;
        System.out.println("执行run");
    }
}
public class test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService execute= Executors.newFixedThreadPool(10);
        int result = 100;
        Future<Integer> future=execute.submit(new Task(result),result);
        FutureTask<Integer> futureTask=new FutureTask<>(()->2+2);
        execute.submit(futureTask);
        Integer o = futureTask.get();
        int re=future.get();
        System.out.println(o);
    }
}
