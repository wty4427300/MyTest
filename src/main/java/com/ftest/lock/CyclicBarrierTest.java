package com.ftest.lock;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;
import java.util.concurrent.*;

public class CyclicBarrierTest {

    private final static Random random = new Random();

    // 订单队列
    private Queue<Integer> pos = new ArrayDeque<>();
    // 派送单队列
    private Queue<Integer> dos = new ArrayDeque<>();

    public int getPOrder() {
        return random.nextInt();
    }

    public int getDOrder() {
        return random.nextInt();
    }

    private boolean diff(int p, int d) {
        return p == d;
    }

    public void check() {
        int p = pos.poll();
        int d = dos.poll();
        boolean diff = this.diff(p, d);
        System.out.println("校验结果:" + diff);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CyclicBarrierTest test = new CyclicBarrierTest();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> executor.submit(test::check), executor);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            futures.add(future);
        });
        CompletableFuture<Void> future1 = CompletableFuture
                .runAsync(() -> {
                    for (int i = 0; i < 10; i++) {
                        test.pos.add(test.getPOrder());
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, executor);
        futures.add(future1);
        CompletableFuture<Void> future2 = CompletableFuture
                .runAsync(() -> {
                    for (int i = 0; i < 10; i++) {
                        test.dos.add(test.getDOrder());
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, executor);
        futures.add(future2);
        CompletableFuture<Void> completable = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        completable.get();
        executor.shutdown();
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }
}

