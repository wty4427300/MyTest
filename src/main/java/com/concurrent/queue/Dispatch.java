package com.concurrent.queue;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Data
class Message {
    private Integer id;
    private String message;

    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

class Worker extends Thread {
    private final Queue<Runnable> runnableQueue;

    public Worker(Queue<Runnable> queue) {
        this.runnableQueue = queue;
    }

    public Queue<Runnable> getRunnableQueue() {
        return this.runnableQueue;
    }

    @Override
    public void run() {
        while (runnableQueue.size() > 0) {
            runnableQueue.poll().run();
            System.out.println("task:" + Thread.currentThread().getName());
        }
    }
}

/**
 * 模拟多线程消费
 */
public class Dispatch {
    public static void main(String[] args) {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0, "order init"));
        messages.add(new Message(0, "order pay"));
        messages.add(new Message(1, "order init"));
        messages.add(new Message(1, "order pay"));
        messages.add(new Message(2, "order init"));
        messages.add(new Message(2, "order pay"));

        Integer threadNum = 3;
        Worker[] threads = new Worker[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Worker(new ArrayDeque<>());
        }

        for (Message msg : messages) {
            int index = msg.getId() % threadNum;
            Queue<Runnable> runnableQueue = threads[index].getRunnableQueue();
            runnableQueue.add(() -> System.out.println(msg.getId() + ":" + msg.getMessage()));
        }

        for (int i = 0; i < threadNum; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++) {
            threads[i].interrupt();
        }
    }
}
