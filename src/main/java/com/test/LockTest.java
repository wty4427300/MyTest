package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class LockTest {
    AtomicInteger state =new AtomicInteger();
    Thread owner=new Thread();
    BlockingQueue<Thread> queue=new LinkedBlockingDeque<>(512);
    public boolean tryLock(){
        if (state.get()==0){
            if (state.compareAndSet(0,1)){
                owner=Thread.currentThread();
                return true;
            }
        }else if(owner==Thread.currentThread()){
            //如果占锁的就是当前线程状态加1
            state.set(state.get()+1);
            return true;
        }
        return false;
    }

    public void lock(){
        if (!tryLock()){
            //没拿到排队
            queue.add(Thread.currentThread());
            LockSupport.park();
            for (;;){
                if (tryLock()){
                    //如果抢到了自己把自己拿出来
                    queue.poll();
                    return;
                }else {
                    LockSupport.park();
                }
            }
        }
    }

    public void unlock(){
        if (owner!=Thread.currentThread()){
            throw new RuntimeException("非法调用");
        }
        if(state.decrementAndGet()==0){//每次减1到0释放
            owner=Thread.currentThread();
            //通知其他线程
            Thread thread=queue.peek();
            if (thread!=null){
                LockSupport.unpark(thread);
            }
        }
    }
}
