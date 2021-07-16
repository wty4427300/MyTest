package com.algorithm;

public class test1 {
    /**
     * 欧几里徳公式,求最大公约数
     */
    public static int gcd(int p,int q){
        if (q==0){
            return p;
        }
        int r=p%q;
        return gcd(q,r);
    }

    public static int rank(int key,int[] array){
        int lo=0;
        //最大的下标=数组长度-1
        int hi=array.length-1;
        while (lo<=hi){
            //开始二分
            int mid=lo+(hi-lo)/2;
            if (key>array[mid]){
                hi=mid-1;
            }else if (key<array[mid]){
                lo=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int gcd = gcd(198, 20);
        System.out.println(gcd);

        int[] array={10,33,434,545,654,232};
        int rank = rank(232, array);
        if (rank==-1){
            System.out.println("没有");
        }else {
            System.out.println(rank);
        }
    }
}
