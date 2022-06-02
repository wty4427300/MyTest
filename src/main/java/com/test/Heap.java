package com.test;

/**
 * 堆相关
 */
public class Heap {
    private int[] a;//存储堆的数组
    private int n;//数组大小
    private int count;//已经存储了多少

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

    public void remove(){
        if (count==0){
            //堆中没有数据
            return;
        }
        //让堆顶和堆尾交换
        a[1]=a[count];
        --count;
        heapify(a,count,1);
    }

    /**
     * @param a 数组
     * @param n 当前存储的数量
     * @param i
     */
    public void heapify(int[] a,int n,int i){
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
            swap(a,i,modPos);
            //节点交换完毕，继续向下判断
            i=modPos;
        }
    }
    private static void buildHeap(int[] a,int n){
        //自下而上的堆化
        for (int i=n/2;i>=1;--i){
            heapify1(a,n,i);
        }
    }

    private static void heapify1(int[] a,int n,int i){
        while (true){
           int maxPos=i;
           if (i*2<=n){

           }
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
        heap.remove();
        for (int i=0;i<=heap.count;i++){
            System.out.println(heap.a[i]);
        }
    }
}
