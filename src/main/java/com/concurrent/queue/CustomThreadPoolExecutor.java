package com.concurrent.queue;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Getter
class MyTask implements Runnable {
    private final String id;
    private final Runnable task;

    public MyTask(String id, Runnable task) {
        this.id = id;
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }
}

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    private final ConcurrentHashMap<Integer, Thread> threadMap = new ConcurrentHashMap<>();

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    @Override
    public void execute(Runnable command) {
        if (command instanceof MyTask) {
            int id = ((MyTask) command).getId().hashCode() % 10;
            threadMap.computeIfAbsent(id, key -> {
                Thread thread = getThreadFactory().newThread(command);
                thread.start();
                return thread;
            });
        }
    }

    @Override
    public void shutdown(){
        super.shutdown();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new CustomThreadPoolExecutor(
                10,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0, "order init"));
        messages.add(new Message(0, "order pay"));
        messages.add(new Message(1, "order init"));
        messages.add(new Message(1, "order pay"));
        messages.add(new Message(2, "order init"));
        messages.add(new Message(2, "order pay"));


        Future<Integer> submit = pool.submit(() -> 1);
        for (Message msg : messages) {
            pool.execute(new MyTask(msg.getId().toString(), () -> System.out.println(msg.getId()+":"+msg.getMessage())));
        }

        pool.shutdown();
    }
}

