package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @param <T> 等待线程池执行完成多任务的几种思考
 */
public class ThreadSafeList<T> {
    private List<T> list;
    private Lock lock;

    public ThreadSafeList() {
        list = new ArrayList<>();
        lock = new ReentrantLock(true);
    }

    public void add(T element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public List<T> getList() {
        lock.lock();
        try {
            return new ArrayList<>(list);
        } finally {
            lock.unlock();
        }
    }

    public static void run1() {
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10000; i++) {
            int element = i;
            executorService.execute(() -> {
                threadSafeList.add(element);
                System.out.println(Thread.currentThread().getName() + " added element: " + element);
            });
        }

        executorService.shutdown();
        //自己阻塞等待
        while (!executorService.isTerminated()) {}
        List<Integer> result = threadSafeList.getList();
        System.out.println("List: " + result);
    }

    public static void run2() throws InterruptedException {
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 设置初始计数器为任务数量
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int element = i;
            executorService.execute(() -> {
                threadSafeList.add(element);
                System.out.println(Thread.currentThread().getName() + " 添加元素: " + element);
                //任务完成，计数器减一
                latch.countDown();
            });
        }
        latch.await(); // 阻塞，直到计数器归零
        executorService.shutdown();
        List<Integer> result = threadSafeList.getList();
        System.out.println("列表: " + result);
    }

    public static void run3() throws InterruptedException {
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(12);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            int element = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                threadSafeList.add(element);
                System.out.println(Thread.currentThread().getName() + " 添加元素: " + element);
            }, executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            allFutures.get(); // 阻塞，直到所有任务完成
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        List<Integer> result = threadSafeList.getList();
        System.out.println("列表: " + result);
    }

    public static void main(String[] args) throws InterruptedException {
        run3();
    }
}

