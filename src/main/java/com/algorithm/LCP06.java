package com.algorithm;

public class LCP06 {
    public int minCount(int[] coins) {
        int cnt=0;
        for(int i:coins){
            if (i>2){
                cnt+=(i+1)/2;
            }else {
                cnt+=1;
            }
        }
        return cnt;
    }
}
