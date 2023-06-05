package com.ftest.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private volatile boolean state;
    final Lock lock=new ReentrantLock();
    //队列不满
    final Condition notFull=lock.newCondition();
    //队列不为空
    final Condition netEmpty=lock.newCondition();
    void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            //条件为队列已满
            while (state){
                notFull.await();
            }
            //入队列操作

            System.out.println("shabi");
            //如队列之后通知可以出队列
            netEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    void deq(T x) throws InterruptedException {
        lock.lock();
        try {
            //队列以空
            while (state){
                //等待队列不为空的时候
                netEmpty.await();
            }
            //省略出队列操作
            System.out.println("shabi");
            //出队列后，通知可以入队列
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }
}
