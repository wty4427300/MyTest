package com.accesslimit.src;

import com.google.common.util.concurrent.RateLimiter;

public class TokenBucket {
    public static void main(String[] args) {
        // 创建一个RateLimiter实例，参数表示每秒产生的令牌数量
        RateLimiter rateLimiter = RateLimiter.create(10.0);
        // 模拟处理一些请求
        for (int i = 1; i <= 20; i++) {
            // 获取一个令牌，如果令牌不可用则等待
            if (!rateLimiter.tryAcquire()) {
                throw new RuntimeException("请求次数太多");
            }
            // 处理请求
            System.out.println("处理请求 " + i);
        }
    }
}
