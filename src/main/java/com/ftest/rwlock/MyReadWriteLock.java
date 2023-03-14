package com.ftest.rwlock;

public class MyReadWriteLock {
    private int readers = 0; // 当前读锁的数量
    private int writers = 0; // 当前写锁的数量
    private int writeRequests = 0; // 写锁等待的请求数量

    /**
     * 获取读锁
     */
    public synchronized void lockRead() throws InterruptedException {
        // 如果当前有写锁或者有写锁的请求，则等待
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        // 读锁数量加1
        readers++;
    }

    /**
     * 释放读锁
     */
    public synchronized void unlockRead() {
        // 读锁数量减1
        readers--;
        // 通知其他等待该锁的线程
        notifyAll();
    }

    /**
     * 获取写锁
     */
    public synchronized void lockWrite() throws InterruptedException {
        // 写锁等待的请求数量加1
        writeRequests++;
        // 如果当前有读锁或者写锁，则等待
        while (readers > 0 || writers > 0) {
            wait();
        }
        // 写锁等待的请求数量减1，写锁数量加1
        writeRequests--;
        writers++;
    }

    /**
     * 释放写锁
     */
    public synchronized void unlockWrite() {
        // 写锁数量减1
        writers--;
        // 通知其他等待该锁的线程
        notifyAll();
    }

    /**
     * 获取指定数量的读锁
     */
    public synchronized void lockReads(int n) throws InterruptedException {
        // 如果当前有写锁或者有写锁的请求，或者读锁数量加上指定数量超过了最大值，则等待
        while (writers > 0 || writeRequests > 0 || readers + n > Integer.MAX_VALUE) {
            wait();
        }
        // 读锁数量加上指定数量
        readers += n;
    }

    /**
     * 释放指定数量的读锁
     */
    public synchronized void unlockReads(int n) {
        // 读锁数量减去指定数量
        readers -= n;
        // 通知其他等待该锁的线程
        notifyAll();
    }
}