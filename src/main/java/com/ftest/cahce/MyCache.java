package com.ftest.cahce;


import sun.misc.Contended;

/**
 * 缓存行性能测试
 */
@Contended
public class MyCache {
    //考虑一般缓存行大小是64字节，一个 long 类型占8字节
    static long[][] arr;
    public static void main(String[] args){
        int size=1024*1024;

        arr=new long[size][];

        for (int i=0;i<size;i++){
            arr[i]=new long[8];
            //8*8为64，是一个缓存行
            for (int j=0;j<8;j++){
                arr[i][j]=0L;
            }
        }
        //上面的代码相当于写入数据
        long sum=0L;
        long marked=System.currentTimeMillis();
        //现在开始读取数据
        for (int i=0;i<size;i++){
            for (int j = 0; j < 8; j++) {
                //按照缓存大小读取，每次都是64字节
                sum = arr[i][j];
            }
        }
        System.out.println("[cache line]Loop times:" + (System.currentTimeMillis() - marked) + "ms");
        marked = System.currentTimeMillis();
        for (int i = 0; i < 8;i++) {
            for (int j = 0; j < size; j++) {
                sum = arr[j][i];
            }
        }
        System.out.println("[no cache line]Loop times:" + (System.currentTimeMillis() - marked) + "ms");
    }
}
