package com.ftest.effectiveNote;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Stack {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT=16;

    public Stack() {
        elements=new Object[DEFAULT];
    }

    /**
     * 每次push的时候需要判断一下是否需要扩容
     */
    public void ensureCapacity(){
        if (elements.length==size){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }

    public Object pop(){
        if (size==0){
            throw new EmptyStackException();
        }
        //这里的问题就是虽然从堆里面清除了size索引的元素,但是elements[size]的引用还在.垃圾回收不会处理这个对象
        //所以我们要做的就是手动吧这里置为null
        Object result = elements[--size];
        elements[size]=null;
        return result;
    }
}
