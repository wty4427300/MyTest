package com.concurrent.queue;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Getter
class MyRunnable implements Runnable {
    private final String id;
    private final Runnable task;

    public MyRunnable(String id, Runnable task) {
        this.id = id;
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }
}

public class CustomThreadFactory implements ThreadFactory {

    private final ConcurrentHashMap<Integer, Thread> threadMap = new ConcurrentHashMap<>();

    @Override
    public Thread newThread(Runnable r) {
        if (r instanceof MyRunnable) {
            int id = ((MyRunnable) r).getId().hashCode() % 10;
            return threadMap.getOrDefault(id, new Thread(r));
        }
        return new Thread(r);
    }


    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new CustomThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0, "order init"));
        messages.add(new Message(0, "order pay"));
        messages.add(new Message(1, "order init"));
        messages.add(new Message(1, "order pay"));
        messages.add(new Message(2, "order init"));
        messages.add(new Message(2, "order pay"));

        for (Message msg : messages) {
            pool.execute(new MyTask(msg.getId().toString(), () -> System.out.println(msg.getId() + ":" + msg.getMessage())));
        }
    }

}

