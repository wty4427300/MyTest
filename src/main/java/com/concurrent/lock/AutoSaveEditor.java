package com.concurrent.lock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AutoSaveEditor {
    private volatile boolean changed = false;

    private final Lock lock = new ReentrantLock();

    private ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    //定时执行自动保存
    public void startAutoSave() {
        ses.scheduleAtFixedRate(this::autoSave, 5, 5, TimeUnit.SECONDS);
    }

    public void autoSave() {
        if (!changed) {
            return;
        }
        lock.lock();
        changed = false;
        lock.unlock();
        this.execSave();
    }

    private void execSave() {
    }

    //编辑操作
    public void edit() {
        //省略编辑逻辑
        lock.lock();
        changed = true;
        lock.unlock();
    }
}
