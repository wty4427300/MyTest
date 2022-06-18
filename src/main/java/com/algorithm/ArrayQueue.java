package com.algorithm;

/**
 * 1.先进先出fifo
 * 2.尾部插入,头部删除
 */
public class ArrayQueue {
    //数组items,数组大小n
    private String[] items;
    private int n=0;
    //head表示队头下标，tail表示队尾
    private int head =0;
    private int tail =0;

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity){
        items=new String[capacity];
        n=capacity;
    }

    public boolean enqueue(String item){
        //如果tail == n 表示队列已经满了
        if(tail == n){
            if(head ==0){
                return false;
            }
            //数据搬迁
            for (int i=head;i<tail;++i){
                items[i-head]=items[i];
            }
            tail-=head;
            head=0;
            return false;
        }
        //没满插在队尾
        items[tail]=item;
        ++tail;
        return true;
    }
    //出队
    public String dequeue(){
        //如果head ==tail 表示队列为空
        if (head == tail){
            return null;
        }
        String ret=items[head];
        ++head;
        return ret;
    }
}
