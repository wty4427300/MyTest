package com.ftest.copyOnWrite;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class RouterTable {
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>>
            rt =new ConcurrentHashMap<>();

    //根据接口名获取路由表
    public Set<Router> get(String iface){
        return rt.get(iface);
    }

    //删除路由
    public void remove(Router router){
        Set<Router> set=rt.get(router);
        if(set!=null){

        }
    }
}
