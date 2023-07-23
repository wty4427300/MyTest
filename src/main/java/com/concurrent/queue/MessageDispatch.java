package com.concurrent.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageDispatch {
    private final List<Worker> workers;
    private volatile boolean isWorker = true;

    /**
     * 构造函数初始化线程池
     */
    public MessageDispatch(int poolSize, int capacity) {
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolSize; i++) {
            //使用有界队列防止任务无限增长
            Worker worker = new Worker(new ArrayBlockingQueue<>(capacity), this);
            worker.start();
            workers.add(worker);
        }
    }

    public static class Worker extends Thread {
        private final MessageDispatch pool;
        private final BlockingQueue<Runnable> queue;

        public Worker(BlockingQueue<Runnable> queue, MessageDispatch pool) {
            this.queue = queue;
            this.pool = pool;
        }

        public Queue<Runnable> getQueue() {
            return queue;
        }

//        非阻塞的方式去取，会频繁的循环，忙等待
//        @Override
//        public void run() {
//            while (this.pool.isWorker || queue.size() > 0) {
//                Runnable task = queue.poll();
//                if (task != null) {
//                    task.run();
//                }
//            }
//        }

        @Override
        public void run() {
            Runnable task = null;
            while (this.pool.isWorker || queue.size() > 0) {
                try {
                    if (this.pool.isWorker) {
                        //工作中默认任务会不断到来，所以阻塞的方式获取，阻塞方式获取。
                        task = this.queue.take();
                    } else {
                        //工作结束，执行完剩下的任务再退出，非阻塞方式拿。
                        task = this.queue.poll();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    break;
                }
                if (task != null) {
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
            if (worker.getState().equals(Thread.State.BLOCKED) || worker.getState().equals(Thread.State.WAITING)) {
                worker.interrupt();//强制中断这个线程
            }
        }
    }

    public static void main(String[] args) {
        MessageDispatch pool = new MessageDispatch(10, 100);

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
