package com.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

//账户类
class Account {
    private Integer banalce;

    public Account(Integer banalce) {
        this.banalce = banalce;
    }

    public void transactionToTarget(Integer money, Account target) {//转账方法
        Allocator.getInstance().apply(this, target);
        this.banalce -= money;
        target.setBanalce(target.getBanalce() + money);
        Allocator.getInstance().release(this, target);
    }

    public Integer getBanalce() {
        return banalce;
    }

    public void setBanalce(Integer banalce) {
        this.banalce = banalce;
    }
}

class Allocator { //单例锁类
    private Allocator() {
    }

    private List<Account> locks = new ArrayList<>();

    public synchronized void apply(Account src, Account tag) {
        while (locks.contains(src) || locks.contains(tag)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locks.add(src);
        locks.add(tag);
    }

    public synchronized void release(Account src, Account tag) {
        locks.remove(src);
        locks.remove(tag);
        this.notifyAll();
    }

    public static Allocator getInstance() {
        return AllocatorSingle.install;
    }

    static class AllocatorSingle {
        public static Allocator install = new Allocator();
    }
}

public class MyLock {
    // 测试转账的main方法
    public static void main(String[] args) throws InterruptedException {
        Account src = new Account(10000);
        Account target = new Account(10000);
        CountDownLatch countDownLatch = new CountDownLatch(9999);
        for (int i = 0; i < 9999; i++) {
            new Thread(() -> {
                src.transactionToTarget(1, target);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("src=" + src.getBanalce());
        System.out.println("target=" + target.getBanalce());
    }
}
