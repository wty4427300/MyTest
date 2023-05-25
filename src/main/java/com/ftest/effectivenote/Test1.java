package com.ftest.effectivenote;

public class Test1 {
    private static long sum1(){
        long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        return sum;
    }
    private static long sum2(){
        Long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long sum1 = sum1();
        long end1 = System.currentTimeMillis();
        System.out.println("时间1:"+(end1-start1));
        long start2 = System.currentTimeMillis();
        long sum2 = sum2();
        long end2 = System.currentTimeMillis();
        System.out.println("时间2:"+(end2-start2));
    }
}
