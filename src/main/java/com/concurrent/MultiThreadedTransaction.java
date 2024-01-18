package com.concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

import java.util.concurrent.CompletableFuture;

@Service
public class MultiThreadedTransaction {

    @Autowired
    private DataSource dataSource;

    @Transactional
    public void test() {
        //获取主线程连接
        ConnectionHolder connectionHolder = (ConnectionHolder) org.springframework.transaction.support.TransactionSynchronizationManager.getResource(dataSource);
        //CompletableFuture方式
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            //子线程绑定主线程连接
            TransactionSynchronizationManager.bindResource(dataSource, connectionHolder);
            //执行子线程的sql
            System.out.println("sql1");
            //解绑连接
            TransactionSynchronizationManager.unbindResource(dataSource);
            int a = 1 / 0;
        });
        completableFuture.join();
        //原生线程方式
        Thread thread = new Thread(() -> {
            //子线程绑定主线程连接
            TransactionSynchronizationManager.bindResource(dataSource, connectionHolder);
            //执行子线程的sql
            //执行子线程的sql
            System.out.println("sql1");
            //解绑连接
            TransactionSynchronizationManager.unbindResource(dataSource);
            int a = 1 / 0;
        });
        thread.start();
        final Throwable[] ta = {null};
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.setUncaughtExceptionHandler((t, e) -> ta[0] = e);
        if (ta[0] != null) {
            throw new RuntimeException(ta[0]);
        }
        //主线程sql
        System.out.println("sql2");
    }
}
