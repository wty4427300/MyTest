package com.algorithm;

/**
 * 循环队列
 */
class MyCircularQueue {
    private int[] queue;
    //队头
    private int he;
    //队尾
    private int ta;
    //队列长度
    private int length;

    /**
     * 构造器设置队列长度为k
     */
    public MyCircularQueue(int k) {
        this.length = k;
        this.queue = new int[k];
    }

    /**
     * 插入一个元素,插入成功返回true
     * 因为是取余操作,所以he和ta可以无限增加直到
     * int溢出
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[ta % length] = value;
        return ++ta >= 0;
    }

    /**
     * 删除一个元素删除成功返回true
     * 循环列表一定是假删除,只需要把头指针向后移即可
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        return ++he >= 0;
    }

    /**
     * 从队首获得元素,如果队列为空,返回-1
     */
    public int Front() {
        return isEmpty() ? -1 : queue[he % length];
    }

    /**
     * 从队尾获取元素,如果队列为空返回-1
     */
    public int Rear() {
        return isEmpty() ? -1 : queue[(ta - 1) % length];
    }

    /**
     * 检查队列是否为空
     */
    public boolean isEmpty() {
        return he == ta;
    }

    /**
     * 检查队列是否已经满了
     */
    public boolean isFull() {
        return ta - he == length;
    }
}

public class test622 {
}
