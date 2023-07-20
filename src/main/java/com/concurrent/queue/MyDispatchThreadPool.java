package com.concurrent.queue;

import java.util.*;

public class MyDispatchThreadPool {
    private final List<Worker> workers;
    private volatile boolean isWorker = true;

    /**
     * 构造函数初始化线程池
     */
    public MyDispatchThreadPool(int poolSize) {
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(new ArrayDeque<>(), this);
            worker.start();
            workers.add(worker);
        }
    }

    public static class Worker extends Thread {
        private final MyDispatchThreadPool pool;
        private final Queue<Runnable> queue;

        public Worker(Queue<Runnable> queue, MyDispatchThreadPool pool) {
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
                    System.out.println("thread:"+Thread.currentThread().getName());
                    task.run();
                }
            }
        }
    }

    public boolean submit(String id, Runnable task) {
        int index = id.hashCode() % this.workers.size();
        Queue<Runnable> runnableQueue = this.workers.get(index).getQueue();
        return runnableQueue.add(task);
    }

    public void shutDown() {
        this.isWorker = false;
        for (Thread worker : workers) {
            if (worker.getState().equals(Thread.State.BLOCKED)) {
                worker.interrupt();//强制中断这个线程
            }
        }
    }

    public static void main(String[] args) {
        MyDispatchThreadPool pool = new MyDispatchThreadPool(3);

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
