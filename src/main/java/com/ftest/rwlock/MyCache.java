package com.ftest.rwlock;

import org.apache.flink.types.MapValue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache<K,V> {
    final Map<K,V> map=new HashMap<>();
    final ReadWriteLock rwl=new ReentrantReadWriteLock();
    final Lock r=rwl.readLock();
    final Lock w=rwl.writeLock();

    V get(K key){
        V v=null;
        r.lock();
        try{
            v= map.get(key);
        }finally {
            r.unlock();
        }
        //缓存中存在就返回
        if (v!=null){
            return v;
        }
        //缓存中不存在
        w.lock();
        try{
            //再验证一遍，因为其他线程可能已经查询了
            v=map.get(key);
            if (v==null){
                //v=查询数据库
                map.put(key,v);
            }
        }finally {
            w.unlock();
        }
        return v;
    }

}
