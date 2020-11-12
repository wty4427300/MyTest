package com.ftest.effectiveNote;

public class Test1 {
    private static long sum(){
        long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = sum();
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("时间:"+(end-start));
    }
}
