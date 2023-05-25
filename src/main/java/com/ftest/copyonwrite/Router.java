package com.ftest.copyonwrite;

/**
 * rpc的路由类
 */
public class Router {
    private String ip;
    private Integer port;
    private String iFace;

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

    public String getIFace() {
        return iFace;
    }

    public void setIFace(String iface) {
        this.iFace = iface;
    }

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iFace = iface;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Router) {
            Router r = (Router) obj;
            return iFace.equals(r.iFace) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }
}

