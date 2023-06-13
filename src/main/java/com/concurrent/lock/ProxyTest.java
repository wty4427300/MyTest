package com.concurrent.lock;


class ProxyTest {
    private boolean started = false;
    //采集线程
    private Thread rptThread;

    //启动采集功能
    public synchronized void start() {
        //不允许同时启动多个采集线程
        if (started) {
            return;
        }
        started = true;
        rptThread = new Thread(() -> {
            while (true) {
                //省略采集、回传实现
                this.report();
                //每隔两秒钟采集、回传一次数据
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
            //执行到此处说明线程马上终止
            started=false;
        });
        rptThread.start();
    }

    //终止采集功能
    synchronized void stop() {
        //如何实现？
    }

    private void report() {
    }
}
