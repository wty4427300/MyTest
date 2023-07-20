package com.concurrent.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyDispatchThreadPool extends ThreadPoolExecutor {
    private final int poolSize;
    private final AtomicInteger nextIndex = new AtomicInteger(0);

    public MyDispatchThreadPool(int poolSize) {
        super(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        this.poolSize = poolSize;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if (r instanceof Task) {
            int index = ((Task) r).getId() % poolSize;
            ((Task) r).setThreadIndex(index);
        }
    }

    public boolean submit(int id, Runnable task) {
        Task wrappedTask = new Task(id, task);
        super.submit(wrappedTask);
        return true;
    }

    public static class Task implements Runnable {
        private final int id;
        private final Runnable task;
        private int threadIndex;

        public Task(int id, Runnable task) {
            this.id = id;
            this.task = task;
        }

        public int getId() {
            return id;
        }

        public void setThreadIndex(int index) {
            this.threadIndex = index;
        }

        @Override
        public void run() {
            System.out.println("Thread Index: " + threadIndex + ", Task ID: " + id);
            task.run();
        }
    }

    public static void main(String[] args) {
        int poolSize = 3;
        MyDispatchThreadPool pool = new MyDispatchThreadPool(poolSize);

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0, "order init"));
        messages.add(new Message(0, "order pay"));
        messages.add(new Message(1, "order init"));
        messages.add(new Message(1, "order pay"));
        messages.add(new Message(2, "order init"));
        messages.add(new Message(2, "order pay"));

        for (Message msg : messages) {
            pool.submit(msg.getId(), () -> System.out.println(msg.getId() + ":" + msg.getMessage()));
        }

        pool.shutdown();
        System.out.println("All tasks are completed.");
    }
}
