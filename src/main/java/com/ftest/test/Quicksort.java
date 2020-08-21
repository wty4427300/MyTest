package com.ftest.test;

public class Quicksort {
    public static void main(String[] args) {
        int[] a = new int[]{8, 10, 2, 3, 6, 1, 5};
        sort(a, a.length);
        for (int c : a) {
            System.out.println(c);
        }

    }

    public static void sort(int[] array, int length) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点,且进行第一次排序
        int q = partition(array, p, r);
        //排序分区点的左边
        quickSort(array, p, q - 1);
        //排序分区点的右边
        quickSort(array, q + 1, r);
    }

    public static int partition(int[] array, int p, int r) {
        //设置分区点位数组最后一位
        int pivot = array[r];
        //获取数组头索引
        int i = p;
        //开始循环遍历
        for (int j = p; j < r; j++) {
            //开始第排序，如果比分区点小放在数组下标i处,放完之后i+1,方便下一个符合条件的数存放,比分区点大放在后面
            if (array[j] < pivot) {
                if (i == j) {
                    //这中情况是array[j]<pivot但是他已经在i处了，不需要作交换所以只需要++i，方便下一个数存储即可
                    ++i;
                } else {
                    swap(array,i,j);
                    i++;
                }
            }
        }
        //这里是吧分区点和未处理区的第一个数[i]进行交换，
        //为啥会出现未处理的i呢，因为上面的算法只处理了的小于分区点的元素。
        //所以此时的i一定是大于分区点的
        swap(array,i,r);
        //经过交换之后，分区点由r变成了i
        return i;
    }

    final public static void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
