package com.ftest.rwlock;

import java.util.concurrent.atomic.AtomicInteger;

public class MyReadWriteCasLock {
    private AtomicInteger readers = new AtomicInteger(0); // 当前读锁的数量
    private AtomicInteger writers = new AtomicInteger(0); // 当前写锁的数量
    private AtomicInteger writeRequests = new AtomicInteger(0); // 写锁等待的请求数量
    private final int maxReadLock=20;
    /**
     * 获取读锁
     */
    public void lockRead() throws InterruptedException {
        while (true) {
            // 如果当前有写锁或者有写锁的请求，则等待
            while (writers.get() > 0 || writeRequests.get() > 0) {
                Thread.sleep(1);
            }
            // 使用CAS操作增加读锁数量
            int value = readers.get();
            if (readers.compareAndSet(value, value + 1)) {
                break;
            }
        }
    }

    /**
     * 释放读锁
     */
    public void unlockRead() {
        // 使用CAS操作减少读锁数量
        int value = readers.get();
        while (true) {
            if (readers.compareAndSet(value, value - 1)) {
                break;
            }
            value = readers.get();
        }
    }

    /**
     * 获取写锁
     */
    public void lockWrite() throws InterruptedException {
        // 使用CAS操作增加写锁等待请求数量
        writeRequests.incrementAndGet();
        while (true) {
            // 如果当前有读锁或者写锁，则等待
            while (readers.get() > 0 || writers.get() > 0) {
                Thread.sleep(1);
            }
            // 使用CAS操作减少写锁等待请求数量，增加写锁数量
            int value = writeRequests.get();
            if (writeRequests.compareAndSet(value, value - 1)) {
                writers.incrementAndGet();
                break;
            }
        }
    }

    /**
     * 释放写锁
     */
    public void unlockWrite() {
        // 使用CAS操作减少写锁数量
        int value = writers.get();
        while (true) {
            if (writers.compareAndSet(value, value - 1)) {
                break;
            }
            value = writers.get();
        }
    }

    /**
     * 获取指定数量的读锁
     */
    public void lockReads(int n) throws InterruptedException {
        while (true) {
            // 如果当前有写锁或者有写锁的请求，或者读锁数量加上指定数量超过了最大值，则等待
            while (writers.get() > 0 || writeRequests.get() > 0 || readers.get() + n > maxReadLock) {
                Thread.sleep(1);
            }
            // 使用CAS操作增加读锁数量
            int value = readers.get();
            if (readers.compareAndSet(value, value + n)) {
                break;
            }
        }
    }

    /**
     * 释放指定数量的读锁
     */
    public void unlockReads(int n) {
        // 使用CAS操作减少读锁数量
        int value = readers.get();
        while (true) {
            if (readers.compareAndSet(value, value - n)) {
                break;
            }
            value = readers.get();
        }
    }
}
