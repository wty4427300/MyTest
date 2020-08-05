package com.ftest.myThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private BlockingQueue<Runnable> blockingQueue;
    private List<Thread> Worker;


    public static class worker extends Thread {
        private MyThreadPool pool;
        public worker(MyThreadPool pool){
            this.pool=pool;
        }
        @Override
        public void  run(){
            Runnable task=null;
            while (this.pool.isWorker||this.pool.blockingQueue.size()>0){
                try {
                    if (this.pool.isWorker){
                        task=this.pool.blockingQueue.take();
                        //阻塞方式拿
                    }else {
                        task=this.pool.blockingQueue.poll();
                        //非阻塞方式拿
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task!=null){
                    task.run();
                    System.out.println("task:"+Thread.currentThread().getName());
                }
            }
        }
    }

    public MyThreadPool(int taskSize,int poolSize) {
            this.blockingQueue=new LinkedBlockingQueue<>(taskSize);
            this.Worker= Collections.synchronizedList(new ArrayList<>());
            for (int i=0;i<poolSize;i++){
                worker worker=new worker(this);
                worker.start();
                Worker.add(worker);
            }
    }
    public boolean submit(Runnable task){
        if (isWorker){
            return blockingQueue.offer(task);
        }else {
            return false;
        }

    }

    private volatile boolean isWorker=true;
    public void  shutDown(){
        this.isWorker=false;

        for (Thread worker:Worker){
            if (worker.getState().equals(Thread.State.BLOCKED)){
                worker.interrupt();//强制中断这个线程
            }
        }
    }
}
