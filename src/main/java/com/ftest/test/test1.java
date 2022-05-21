package com.ftest.test;

public class test1 {
    public static void main(String[] args) {
        int[] array = new int[]{8, 10, 2, 3, 6, 1, 5};
        quickSort(array, 0, array.length - 1);
        for (int a:array){
            System.out.println(a);
        }
    }

    public static void quickSort(int[] array,int p,int r){
        if (p>=r){
            return;
        }
        int q=partition(array,p,r);
        quickSort(array,p,q-1);
        quickSort(array,p+1,r);
    }

    public static int partition(int[] array,int p,int r){
        //设置分区点为数组的最后一位
        int pivot =array[r];
        //获取数组头索引
        int i=p;
        for (int j=p;j<r;j++){
            if (array[j]<pivot){
                if (i==j){
                    i++;
                }else {
                    swap(array,i,j);
                    i++;
                }
            }
        }
        swap(array, i, r);
        return i;

    }

    public static void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
