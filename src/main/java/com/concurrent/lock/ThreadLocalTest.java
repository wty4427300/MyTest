package com.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 给每个线程分配一个唯一id
 */
public class ThreadLocalTest {

    private static final AtomicLong nextId = new AtomicLong(0);

    private static final ThreadLocal<Long> tl = ThreadLocal.withInitial(nextId::getAndIncrement);

    public ThreadLocalTest() {
        // 默认构造函数
    }

    /**
     * 获取当前线程的唯一ID
     *
     * @return 当前线程的唯一ID
     */
    public static long getThreadId() {
        return tl.get();
    }

    /**
     * 在线程池中使用ThreadLocal并确保其正确释放
     *
     * @param executorService 用于执行任务的线程池
     * @param task            使用ThreadLocal的任务
     */
    public void executeWithThreadLocal(ExecutorService executorService, Runnable task) {
        executorService.execute(() -> {
            tl.set(1L); // 初始化或覆盖当前线程的ThreadLocal值
            try {
                task.run();
            } finally {
                tl.remove(); // 清理当前线程的ThreadLocal
            }
        });
    }

    /**
     * 示例：使用单线程线程池执行任务并展示ThreadLocal的使用
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        ExecutorService es = Executors.newFixedThreadPool(10);
        threadLocalTest.executeWithThreadLocal(es, () -> {
            System.out.println("Task executed by thread: " + Thread.currentThread().getName());
            System.out.println("Thread-local ID for this thread: " + ThreadLocalTest.getThreadId());
        });

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);
    }
}