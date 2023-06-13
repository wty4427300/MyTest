package com.concurrent.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class GuardedObject<T> {
    private T obj;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private final int timeout = 1;

    private static final Map<Object, GuardedObject<?>> gos = new ConcurrentHashMap<>();

    public static <K, T> GuardedObject<T> create(K key) {
        GuardedObject<T> go = new GuardedObject<>();
        gos.put(key, go);
        return go;
    }

    public static <K, T> void fireEvent(K key, T obj) {
        GuardedObject<T> go = (GuardedObject<T>) gos.remove(key);
        if (go != null) {
            go.onChange(obj);
        }
    }

    /**
     * Predicate 这个内置func表示接受一个参数返回一个布尔值
     */
    public T get(Predicate<T> p) {
        lock.lock();
        try {
            //不符合条件await
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        //符合条件就返回obj
        return obj;
    }

    /**
     * 被保护的对象改变了,就唤起等待的线程.
     */
    public void onChange(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
