package com.algorithm;

import java.util.concurrent.Semaphore;

public class test1117 {
    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        h2O.hydrogen(() -> System.out.println("h"));
        h2O.hydrogen(() -> System.out.println("h"));
        h2O.oxygen(() -> System.out.println("o"));
    }
}

class H2O {
    private Semaphore hsemaphore;
    private Semaphore osemaphore;

    public H2O() {
        this.hsemaphore = new Semaphore(2);
        this.osemaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hsemaphore.acquire();
        releaseHydrogen.run();
        osemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        osemaphore.acquire(2);
        releaseOxygen.run();
        hsemaphore.release(2);
    }
}
