package com.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyAqsLock implements Lock {
    MyAqs myAqs=new MyAqs(){
        @Override
        public boolean tryAcquire() {
            return owner.compareAndSet(null,Thread.currentThread());
        }

        @Override
        public boolean tryRelease() {
            return owner.compareAndSet(Thread.currentThread(),null);
        }
    };

    @Override
    public void lock() {
        myAqs.acquire();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return myAqs.tryAcquire();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        myAqs.release();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
