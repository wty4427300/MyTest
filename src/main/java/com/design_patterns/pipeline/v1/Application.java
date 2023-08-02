package com.design_patterns.pipeline.v1;

public class Application {
    public static void main(String[] args) {
        HandlerChain<String> chain = new HandlerChain<>();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle("上下文");
    }
}