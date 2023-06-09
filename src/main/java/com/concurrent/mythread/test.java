package com.concurrent.mythread;

public class test {
    public static void main(String[] args) {
//        ForkJoinPool forkJoinPool=new ForkJoinPool();
//        FrokJion task=new FrokJion(0L,100000000L);
//        Long invoke=forkJoinPool.invoke(task);
//        System.out.println(invoke);
//        Long l=System.currentTimeMillis();
//        LongStream.rangeClosed(0,10000000000L).parallel().reduce(0,Long::sum);
//        Long l2=System.currentTimeMillis();
//        System.out.println(l2-l);
        f();
    }
    public static void f() {
//        int x = 1;    // x指向内存地址A，内容是整数1
//        int y = x;    // y指向同样的内存地址A，内容是整数1
//        x = 2;        // x指向另一个内存地址B，内容是整数2。y仍然指向地址A，内容是1。
        String[] a =new String[10];
        Object[] b = (Object[]) a;
        a[0] = "hi";
        b[1] = 1;
//        int x = 1;    // x指向内存地址A，内容是整数1
//        int y = x;    // y指向同样的内存地址A，内容是整数1
//        x = 2;        // x指向另一个内存地址B，内容是整数2。y仍然指向地址A，内容是1。
//        System.out.println(y);
//        System.out.println(x);

    }
}
