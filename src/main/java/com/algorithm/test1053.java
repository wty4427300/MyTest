package com.algorithm;

public class test1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n=arr.length;
        for(int i=n-1;i>0;--i){
            if (arr[i-1]>arr[i]){
                for (int j=n-1;j>i-1;--j){
                    if (arr[j]<arr[i-1] && arr[j]!=arr[j-1]){
                        int t=arr[i-1];
                        arr[i-1]=arr[j];
                        arr[j]=t;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }
}