package com.concurrent.lock;

public class DeadlockExample {

    // 定义两个静态对象作为锁
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock 1");

                // 在持有lock1的同时尝试获取lock2
                try {
                    Thread.sleep(100); // 增加一点随机性，以便更好地模拟死锁情况
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 此时若thread2已经持有lock2，则会阻塞在此
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock 2");

                // 在持有lock2的同时尝试获取lock1
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 此时若thread1已经持有lock1，则会阻塞在此
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock 1");
                }
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待所有线程完成（在这个示例中它们将无法完成，因为发生了死锁）
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution"); // 实际上由于死锁，这条语句不会被执行
    }
}
