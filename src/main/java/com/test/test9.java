package com.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ayuan
 * @Description: sync
 * @date 2023/5/18 09:33
 */
public class test9 {

    public static void main(String[] args) {
        TicketConsumer t = new TicketConsumer(10);
        Thread my = new Thread(t, "my");
        Thread your = new Thread(t, "your");
        Thread wty = new Thread(t, "wty");
        my.start();
        your.start();
        wty.start();
    }
}

class TicketConsumer implements Runnable {

    public volatile int ticket;
    private final ReentrantLock lock = new ReentrantLock(true);
    public TicketConsumer(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
            if (ticket > 0) {
                //模拟抢票延迟
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            } else {
                lock.unlock();
                return;
            }
            lock.unlock();
        }
    }
}
