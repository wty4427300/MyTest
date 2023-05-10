package com.ftest.MyThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyFutureTask<T> implements Runnable {
    private Callable<T> callable;
    private T result;
    private volatile State state = State.NEW;
    private BlockingQueue<Thread> queue = new ArrayBlockingQueue<>(1);
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public MyFutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() throws InterruptedException {
        lock.lock();
        try {
            if (state == State.NEW) {
                queue.put(Thread.currentThread());
                while (state != State.DONE) {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
            state = State.DONE;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread thread = queue.poll();
            while (thread != null) {
                lock.lock();
                try {
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
                thread = queue.poll();
            }
        }
    }

    private enum State {
        NEW, DONE
    }
}
