package com.ftest.copyOnWrite;

import org.apache.flink.table.expressions.E;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * rpc的路由类
 */
public class Router {
    private String ip;
    private Integer port;
    private String iface;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIface() {
        return iface;
    }

    public void setIface(String iface) {
        this.iface = iface;
    }

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    public boolean equals(Object obj){
        if(obj instanceof Router){
             Router r=(Router)obj;
             return iface.equals(r.iface)&&
                     ip.equals(r.ip)&&
                     port.equals(r.port);
        }
        return false;
    }

    public int hashCode(){
        return 0;
    }
}
class RoutertTable{
    //Key:接口名
    //Value:路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>>
     rt=new ConcurrentHashMap<>();
    //根据接口名获取路由表
    public Set<Router> get(String iface){
        return rt.get(iface);
    }
    //删除路由
    public void remove(Router router){
        Set<Router> set=rt.get(router.getIface());
        if(set!=null){
            set.remove(router);
        }
    }
    //增加路由
    public void add(Router router){
        Set<Router> set=rt.computeIfAbsent(router.getIface(),r->new CopyOnWriteArraySet<>());
        set.add(router);
    }
}

