package com.ftest.mythread;

//我这个接口实现了一个run方法需要传入一个上下文.
public interface ParamterizeThreadStart<T> {
    void run(T context);
}
