package com.concurrent.once;

import java.util.concurrent.atomic.AtomicBoolean;

public class Once {
    private final AtomicBoolean executed = new AtomicBoolean(false);

    public void doOnce(Runnable action) {
        if (executed.compareAndSet(false, true)) {
            action.run();
        }
    }

    public static void main(String[] args) {
        Once once = new Once();
        // 这个方法只会被执行一次
        once.doOnce(() -> System.out.println("Hello, World!"));
        // 这个方法不会被执行
        once.doOnce(() -> System.out.println("Hello, Java!"));

    }
}
