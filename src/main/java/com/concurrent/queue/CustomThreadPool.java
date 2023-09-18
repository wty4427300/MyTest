//package com.concurrent.queue;
//
//import java.util.concurrent.*;
//
//public class CustomThreadPool {
//    private final ConcurrentHashMap<Integer, ExecutorService> threadPools = new ConcurrentHashMap<>();
//
//    public void submitTask(CustomTask task) {
//        int taskId = task.getId();
//        ExecutorService pool = threadPools.computeIfAbsent(taskId, k -> Executors.newSingleThreadExecutor());
//        pool.submit(task);
//    }
//
//    public void shutdown() {
//        for (ExecutorService pool : threadPools.values()) {
//            pool.shutdown();
//        }
//    }
//
//    public static void main(String[] args) {
//        CustomThreadPool customThreadPool = new CustomThreadPool();
//
//        // 创建具有相同 ID 的 CustomTask 并提交到自定义线程池
//        CustomTask task1 = new CustomTask("Task-1", 1);
//        customThreadPool.submitTask(task1);
//
//        CustomTask task2 = new CustomTask("Task-2", 1); // 使用相同的 ID
//        customThreadPool.submitTask(task2);
//
//        // 关闭线程池
//        customThreadPool.shutdown();
//    }
//}
