package com.concurrent.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyDispatch {
    private final List<Worker> workers;
    private volatile boolean isWorker = true;

    /**
     * 构造函数初始化线程池
     */
    public MyDispatch(int poolSize, int capacity) {
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolSize; i++) {
            //使用有界队列防止任务无限增长
            Worker worker = new Worker(new ArrayBlockingQueue<>(capacity), this);
            worker.start();
            workers.add(worker);
        }
    }

    public static class Worker extends Thread {
        private final MyDispatch pool;
        private final BlockingQueue<Runnable> queue;

        public Worker(BlockingQueue<Runnable> queue, MyDispatch pool) {
            this.queue = queue;
            this.pool = pool;
        }

        public Queue<Runnable> getQueue() {
            return queue;
        }

        @Override
        public void run() {
            while (this.pool.isWorker || queue.size() > 0) {
                Runnable task = queue.poll();
                if (task != null) {
                    task.run();
                }
            }
        }

//        public void run() {
//            Runnable task = null;
//            while (this.pool.isWorker || queue.size() > 0) {
//                try {
//                    if (this.pool.isWorker) {
//                        //阻塞方式拿
//                        task = this.queue.take();
//                    } else {
//                        //非阻塞方式拿
//                        task = this.queue.poll();
//                    }
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    e.printStackTrace();
//                }
//                if (task != null) {
//                    task.run();
//                    System.out.println("task:" + Thread.currentThread().getName());
//                }
//            }
//        }
    }

    public boolean submit(String id, Runnable task) {
        int index = id.hashCode() % this.workers.size();
        Queue<Runnable> runnableQueue = this.workers.get(index).getQueue();
        return runnableQueue.add(task);
    }

    public void shutDown() {
        this.isWorker = false;
        for (Thread worker : workers) {
            if (worker.getState().equals(Thread.State.BLOCKED) && !worker.isInterrupted()) {
                worker.interrupt();//强制中断这个线程
            }
        }
    }

    public static void main(String[] args) {
        MyDispatch pool = new MyDispatch(10, 100);

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0, "order init"));
        messages.add(new Message(0, "order pay"));
        messages.add(new Message(1, "order init"));
        messages.add(new Message(1, "order pay"));
        messages.add(new Message(2, "order init"));
        messages.add(new Message(2, "order pay"));

        for (Message msg : messages) {
            pool.submit(msg.getId().toString(), () -> System.out.println(msg.getId() + ":" + msg.getMessage()));
        }

        pool.shutDown();
    }
}
