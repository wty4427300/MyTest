package com.ftest.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public int getPOrder() {
        return 0;
    }

    public int getDOrder() {
        return 0;
    }

    public boolean check(int p, int d) {
        return p == d;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatchTest test = new CountDownLatchTest();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        int[] pd = new int[2];
        //两个步骤并发执行
        executor.execute(() -> {
            pd[0] = test.getPOrder();
            countDownLatch.countDown();
        });
        executor.execute(() -> {
            pd[1] = test.getDOrder();
            countDownLatch.countDown();
        });
        //等待计数器归0,两个任务执行完毕
        countDownLatch.await();
        boolean result = test.check(pd[0], pd[1]);
        System.out.println(result);
        executor.shutdown();
    }
}
