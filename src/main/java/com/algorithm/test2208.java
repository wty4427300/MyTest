package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class test2208 {
    public int halveArray(int[] nums) {
        //创建一个大顶堆
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //将数组存储大顶堆
        double sum=0;
        for (int num : nums) {
            pq.offer((double) num);
            sum+= num;
        }
        int res = 0;
        double sum2 = 0.0;
        while (sum2<sum/2){
            double x= pq.poll();
            double half = x / 2;
            sum2+=half;
            pq.offer(half);
            res++;
        }
        return res;
    }
}
