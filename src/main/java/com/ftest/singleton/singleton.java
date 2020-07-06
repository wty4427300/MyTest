package com.ftest.singleton;
//双检锁单例
public class singleton {
    private volatile static singleton instance;

    public static singleton getInstance(){
        if (instance==null){
            synchronized (singleton.class){
                if (instance==null){
                    instance=new singleton();
                }
            }
        }
        return instance;
    }
}
