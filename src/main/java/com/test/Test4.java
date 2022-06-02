package com.test;

public class Test4 {
    public static void main(String[] args) {
        Object lock=new Object();

        Thread thread1=new Thread(){
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0;i<5;i++){
                        System.out.println("thread1:"+i);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread thread2=new Thread(){
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0;i<5;i++){
                        System.out.println("thread2:"+i);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
