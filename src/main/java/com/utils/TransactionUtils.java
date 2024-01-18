package com.utils;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

//一个使用场景
//redis分布式锁的时候用到过
//之前解锁写在事务里面
//然后事务还没提交完就解锁了
//并发下根本锁不住
public class TransactionUtils {
    public static void doTransactionCompletion(DoTransactionCompletion doTransactionCompletion) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(doTransactionCompletion);
        }
    }

    /**
     * 对应的测试代码
     */
    @Transactional
    public void test() {
        //start tx
        //随便写点sql
        TransactionUtils.doTransactionCompletion(new DoTransactionCompletion(() -> {
            System.out.println("事务执行完成之后");
        }));
        //end tx
    }
}

class DoTransactionCompletion implements TransactionSynchronization {

    private final Runnable runnable;

    public DoTransactionCompletion(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            this.runnable.run();
        }
    }
}
