package com.ftest.test;

/**
 * 线程组的demo,还有优先级
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("lcz is bitch"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "抛出了异常: " + e.getMessage());
            }
        };

        Thread thread=new Thread(threadGroup,()->{
            System.out.println("nb");
            System.out.println("线程组的名"+Thread.currentThread().getThreadGroup().getName());
            throw new RuntimeException("shabi");
        });
        //设置线程优先级默认优先级是5
        thread.setPriority(10);
        thread.start();
    }
}
