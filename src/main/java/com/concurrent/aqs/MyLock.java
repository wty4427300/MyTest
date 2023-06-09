package com.concurrent.aqs;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class MyLock implements Lock {
    //判断一个锁的状态或者说拥有者
    volatile AtomicReference<Thread> owner=new AtomicReference<>();
    //保存正在等待的线程
    volatile LinkedBlockingQueue<Thread> waiter=new LinkedBlockingQueue<>();

    @Override
    public void lock() {
        boolean add0 =true;
        while (!tryLock()){
            if (add0){
                //没拿到锁，加入到等待集合
                waiter.offer(Thread.currentThread());
                add0=false;
            }else {
                //阻塞当前线程不要往下再继续跑了
                LockSupport.park();//伪唤醒，非unpark的唤醒
            }
        }
        //拿到锁移除线程
        waiter.offer(Thread.currentThread());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null,Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //释放owner
        if(owner.compareAndSet(Thread.currentThread(),null)){
            Iterator<Thread> iterator=waiter.iterator();
            while (iterator.hasNext()){
                Thread next=iterator.next();
                LockSupport.unpark(next);
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
