package com.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程顺序打印
 */
public class PrintABC {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();
    private volatile int flag = 1;

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                conditionA.await();
            }
            System.out.print("A");
            flag = 2;
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                conditionB.await();
            }
            System.out.print("B");
            flag = 3;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                conditionC.await();
            }
            System.out.print("C");
            System.out.println(); // 换行
            flag = 1;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printABC.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printABC.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printABC.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
