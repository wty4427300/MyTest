package com.concurrent.mythread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a=0;
        Callable<Object> callable=new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return a;
            }
        };
        FutureTask<Object> futureTask=new FutureTask<Object>(callable);
        new Thread(futureTask).start();
        Object o=futureTask.get();
        System.out.println(o.getClass());
        System.out.println(a);

        //我的线程池的测试
        MyThreadPool myThreadPool=new MyThreadPool(10,10);
        myThreadPool.submit(() -> System.out.println("快乐就完事了"));
        myThreadPool.shutDown();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(512));
        FutureTask<Object> f1=new FutureTask<Object>(callable);
        new Thread(f1).start();
        int o1 =(int) f1.get();
        System.out.println(o1);
    }
}
