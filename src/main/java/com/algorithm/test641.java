package com.algorithm;

class MyCircularDeque {
    private int cap;
    private int size;
    private int[] arr;
    private int front, last;

    public MyCircularDeque(int k) {
        this.cap = k;
        this.size = 0;
        this.arr = new int[cap];
        this.front = 0;
        this.last = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        arr[front] = value;
        front = this.index(front + 1);
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        last = this.index(last - 1);
        arr[last] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = this.index(front - 1);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        last = this.index(last + 1);
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[this.index(front - 1)];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    /**
     * 取余计算索引位置
     */
    private int index(int index) {
        return (index + cap) % cap;
    }
}

public class test641 {
    public static void main(String[] args) {
        MyCircularDeque deque=new MyCircularDeque(5);
        deque.insertFront(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertLast(4);
    }
}
