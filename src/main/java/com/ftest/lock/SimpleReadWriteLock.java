package com.ftest.lock;

import java.util.concurrent.locks.LockSupport;

public class SimpleReadWriteLock {

    private volatile int count = 0;// 记录当前读锁被获取的次数
    private boolean writer = false; // 记录当前写锁是否被获取
    private int readers = 0; // 记录当前读锁被获取的线程数

    public synchronized void readLock() {
        while (writer) {
            //如果写锁被获取，则等待
            LockSupport.park(this);
        }
        // 增加读锁数量
        readers++;
        LockSupport.unpark(Thread.currentThread());
    }

    public synchronized void writeLock() {
        while (writer || readers > 0) {
            // 如果有线程持有读锁或写锁，则等待
            LockSupport.park(this);
        }
        writer = true; // 获取写锁
        LockSupport.unpark(Thread.currentThread());
    }

    public synchronized void releaseReadLock() {
        //释放读锁
        count--;
        if (count == 0) {
            // 唤醒写线程或多个读线程
            LockSupport.unpark(Thread.currentThread());
        }
    }

    public synchronized void releaseWriteLock() {
        // 释放写锁
        writer = false;
        // 唤醒所有等待的读线程和写线程
        LockSupport.unpark(Thread.currentThread());
    }
}
