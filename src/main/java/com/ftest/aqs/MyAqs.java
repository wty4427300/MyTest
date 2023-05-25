package com.ftest.aqs;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class MyAqs {
    //判断一个锁的状态或者说拥有者
    volatile AtomicReference<Thread> owner=new AtomicReference<>();
    //保存正在等待的线程
    volatile LinkedBlockingQueue<Thread> waiter=new LinkedBlockingQueue<>();
    //资源状态
    volatile AtomicInteger state=new AtomicInteger(0);

    public boolean tryAcquire(){
        //交给使用者实现
        throw new UnsupportedOperationException();
    }

    public void acquire(){
        boolean add0 =true;
        while (!tryAcquire()){
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

    public void release(){
        if(tryRelease()){
            //释放owner
            if(owner.compareAndSet(Thread.currentThread(),null)){
                Iterator<Thread> iterator=waiter.iterator();
                while (iterator.hasNext()){
                    Thread next=iterator.next();
                    LockSupport.unpark(next);
                }
            }
        }
    }

    public boolean tryRelease(){
        throw new UnsupportedOperationException();
    }
}
