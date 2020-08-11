package com.ftest.myThread;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class MyfutureTask<T> implements Runnable{
    Callable<T> callable;

    T result;

    volatile String state="NEW";

    LinkedBlockingQueue<Thread> queue=new LinkedBlockingQueue<>();

    public MyfutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    public T get(){
        //阻塞
        if (state.equals("END")){
            return result;
        }
        while (!"END".equals(state)){
            queue.add(Thread.currentThread());
            LockSupport.park();
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result=callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            state="END";
        }
        Thread thread=queue.poll();
        while (queue!=null){
            LockSupport.unpark(thread);
            thread=queue.poll();
        }
    }
}
