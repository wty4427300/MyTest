package com.concurrent.mythread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        //write your code here
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 100; i++) {
            executor.execute(new ParamterizeThread<>(i, (p) -> {
                System.out.println(p.toString());
            }));
        }

        MyThread myThread = new MyThread("shabi");
        myThread.start();

        Thread thread = new Thread(new MyRunnableName("naocan"));
        thread.start();

        MyThread3 myThread3 = new MyThread3(new Work());
        myThread3.start();
    }
}

//由构造方法传递数据
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name);
    }

}

//通过变量和方法传递数据
class MyRunnableName implements Runnable {
    private String name;

    public MyRunnableName(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("hello " + name);
    }
}

//通过回调函数
class Date {
    public int value = 0;
}

//遍历所有参数并算出总和
class Work {
    public void process(Date date, Integer... numbers) {
        for (int n : numbers) {
            date.value += n;
        }
    }
}

class MyThread3 extends Thread {
    private Work work;

    public MyThread3(Work work) {
        this.work = work;
    }


    public void run() {
        Random random = new Random();
        Date date = new Date();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        work.process(date, n1, n2, n3);
    }
}