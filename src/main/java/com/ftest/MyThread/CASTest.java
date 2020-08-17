package com.ftest.MyThread;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    volatile static AtomicInteger count=new AtomicInteger(0);
    public static void addOne(){
        int newValue=0;
        do {
            newValue=count.getAndIncrement();
        }while (count.compareAndSet(count.get(),newValue));
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    addOne();
                    System.out.println("线程1----"+count);
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    addOne();
                    System.out.println("线程2----"+count);
                }
            }
        });
        thread.start();
        thread2.start();
    }
}
