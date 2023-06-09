package com.concurrent.mythread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> f1=CompletableFuture.supplyAsync(()->{
            System.out.println("第一步杀死刘超智");
            return "hanhan";
        });
        CompletableFuture<String> f2=CompletableFuture.supplyAsync(()->{
            System.out.println("第一步杀死熊正行");
            return "shabi";
        });
        CompletableFuture<String> f3=f1.thenCombine(f2,(a, tf)->{
            System.out.println("前两步ok");
            return "END"+tf+a;
        });
        f3.join();
        
    }
}
