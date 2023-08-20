package com.algorithm;

public class test1281 {
    public int subtractProductAndSum(int n) {
        int m=1,s=0;
        while (n!=0){
            int x=n%10;
            n/=10;
            m*=x;
            s+=x;
        }
        return m-s;
    }

    public static void main(String[] args) {
        int n=111;
        System.out.println(n%10);
        System.out.println(n/10);
    }
}
