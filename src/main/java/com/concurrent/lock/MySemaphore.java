package com.concurrent.lock;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    final static Semaphore semaphore=new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            int finalI = i;
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    semaphore.release();
                }
            });
            semaphore.acquire();
            thread.start();
        }
    }
}
