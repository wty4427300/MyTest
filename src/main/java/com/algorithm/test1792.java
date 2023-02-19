package com.algorithm;

import java.util.PriorityQueue;

public class test1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //构建优先队列的规则
        PriorityQueue<int[]> queue=new PriorityQueue<>(
                (a,b)->{
                    long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
                    long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
                    if (val1 == val2) {
                        return 0;
                    }
                    return val1 < val2 ? 1 : -1;
                }
        );
        //初始化优先级队列
        for(int[] c:classes){
            queue.offer(new int[]{c[0],c[1]});
        }
        //分配必能通过的学生
        for(int i=0;i<extraStudents;i++){
            int[] arr=queue.poll();
            int pass=arr[0],total=arr[1];
            queue.offer(new int[]{pass+1,total+1});
        }
        //计算总通过率
        double res=0;
        for(int i=0;i<classes.length;i++){
            int[] arr=queue.poll();
            int pass=arr[0],total=arr[1];
            res+=1.0 * pass/total;
        }
        //计算平均通过率
        return res/classes.length;
    }
}
