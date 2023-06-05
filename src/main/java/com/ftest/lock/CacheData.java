package com.ftest.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheData {
    Object data;
    volatile boolean cacheValid;
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();
    void processCacheDate(){
        r.lock();
        if(!cacheValid){
            r.unlock();
            w.lock();
            try{
                if (!cacheValid){
                    data="shabi";
                    cacheValid=true;
                }
                r.lock();
            }finally {
                w.unlock();
            }
        }
        try{

        }finally {
            r.unlock();
        }
    }
}
