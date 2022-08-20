package com.test;

/**
 * volatile的简单例子
 */
public class Test3 {
    private static volatile int signal=0;

    static  class ThreadA implements Runnable{

        @Override
        public void run() {
            while (signal<5) {
                if (signal%2==0){
                    System.out.println("A"+signal);
                    signal++;
                }
            }
        }

    }
    static class ThreadB implements Runnable{

        @Override
        public void run() {
            while (signal<5){
                if(signal%2==1){
                    System.out.println("B"+signal);
                    signal++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
