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

    public void remove(int index){
        if (count==0){
            //堆中没有数据
            return;
        }
        a[index]=a[count];
        --count;
        delete(a,count,index);
    }

    public void delete(int[] a,int n,int i){
        while (true){
            int modPos=i;
            //判断左节点
            if (i*2<=n&&a[i]<a[i*2]){
                modPos=i*2;
            }
            //判断右节点
            if (i*2+1<=n&&a[i]<a[i*2+1]){
                modPos=i*2+1;
            }
            if (modPos==i){
                break;
            }
            //交换需要堆化的节点
            swap(a, i, modPos);
            //节点交换完毕，继续向下判断
            i=modPos;
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
