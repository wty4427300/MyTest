package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test14 {
    private static AtomicInteger sum = new AtomicInteger(0);
    private static ConcurrentHashMap<Integer, Integer> counts = new ConcurrentHashMap<>();

    public static int init() {
        HashMap map = new HashMap<>();
        return sum.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 10000000; j++) {
                    int i1 = init();
                    counts.put(i1, counts.getOrDefault(i1, 0) + 1);
                }
            });
        }

        // 等待所有线程完成任务
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        // 检查是否有重复的 sum 值
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("验证通过：没有发现重复的 sum 值");
        } else {
            System.out.println("验证失败：发现以下重复的 sum 值：" + duplicates);
        }
        HashMap map = new HashMap<>();
    }
}
