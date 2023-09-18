package com.concurrent.mythread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private final BlockingQueue<Runnable> blockingQueue;
    private final List<Thread> workers;
    private volatile boolean isWorker = true;

    public static class worker extends Thread {
        private final MyThreadPool pool;

        public worker(MyThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            Runnable task = null;
            while (this.pool.isWorker || !this.pool.blockingQueue.isEmpty()) {
                try {
                    if (this.pool.isWorker) {
                        //阻塞方式拿
                        task = this.pool.blockingQueue.take();
                    } else {
                        //非阻塞方式拿
                        task = this.pool.blockingQueue.poll();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                    System.out.println("task:" + Thread.currentThread().getName());
                }
            }
        }
    }

    public MyThreadPool(int taskSize, int poolSize) {
        this.blockingQueue = new LinkedBlockingQueue<>(taskSize);
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolSize; i++) {
            worker worker = new worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    public boolean submit(Runnable task) {
        if (isWorker) {
            return blockingQueue.offer(task);
        } else {
            return false;
        }
    }

    public void shutDown() {
        this.isWorker = false;

        for (Thread worker : workers) {
            if (worker.getState().equals(Thread.State.BLOCKED)) {
                worker.interrupt();//强制中断这个线程
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //我的线程池的测试
        MyThreadPool myThreadPool = new MyThreadPool(10, 10);
        myThreadPool.submit(() -> System.out.println("快乐就完事了"));
        myThreadPool.shutDown();
    }
}
