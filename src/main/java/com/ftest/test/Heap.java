package com.ftest.test;

/**
 * 堆相关
 */
public class Heap {
    private int[] a;//存储堆的数组
    private int n;//数组大小
    private int count;//以存储数

    public Heap(int capacity){
        a=new int[capacity+1];
        n=capacity;
        count=0;
    }

    public void insert(int data){
        if (count>=n){
            //数组满了
            return;
        }
        ++count;
        a[count]=data;
        int i=count;
        while (i/2>0&&a[i]>a[i/2]){
            //自下往上的堆化
            swap(a,i,i/2);
            //子节点和父节点交换，之后继续向上比较
            i=i/2;
        }
    }

    public static void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        Heap heap=new Heap(10);
        heap.insert(10);
        heap.insert(11);
        heap.insert(5);
        heap.insert(8);
        for (int a: heap.a){
            System.out.println(a);
        }
    }
}
