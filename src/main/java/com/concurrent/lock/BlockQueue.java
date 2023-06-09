package com.concurrent.lock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private final Integer cap;
    private final Queue<T> queue;
    private final Lock lock = new ReentrantLock();
    //队列不满
    private final Condition notFull = lock.newCondition();
    //队列不为空
    private final Condition netEmpty = lock.newCondition();

    public BlockQueue(Integer cap) {
        this.cap = cap;
        this.queue = new ArrayDeque<>(cap);
    }

    public void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            //条件为队列已满
            while (queue.size() == cap) {
                System.out.println("队列已满");
                notFull.await();
            }
            //入队列操作
            queue.add(x);
            //入队列之后通知可以出队列
            netEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T deq() throws InterruptedException {
        lock.lock();
        T t;
        try {
            //队列以空
            while (queue.isEmpty()) {
                System.out.println("队列以空");
                netEmpty.await();
            }
            //省略出队列操作
            t = queue.poll();
            //出队列后，通知可以入队列
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        BlockQueue<Integer> queue = new BlockQueue<>(5);
        Thread thread1= new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    queue.enq(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2= new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Integer q = queue.deq();
                    System.out.println(q);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
