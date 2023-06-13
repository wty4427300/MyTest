package com.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 给每个线程分配一个唯一id
 */
public class ThreadLocalTest {

    private static final AtomicLong nextId = new AtomicLong(0);

    private static final ThreadLocal<Long> tl = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static long get() {
        return tl.get();
    }

    /**
     * 线程池使用thread local需要手动释放
     */
    public void es(){
        ExecutorService es= Executors.newSingleThreadExecutor();
        es.execute(()->{
            tl.set(1L);
            try {

            }finally {
                tl.remove();
            }
        });
    }
}
