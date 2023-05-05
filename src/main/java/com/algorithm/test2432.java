package com.algorithm;

public class test2432 {
    public int hardestWorker(int n, int[][] logs) {
        int last=0,mx=0,ans=0;
        for (int[] log:logs){
            int uid = log[0];
            int time = log[1];
            time -= last;
            if (mx<time ||(mx == time && ans>uid)){
                ans=uid;
                mx=time;
            }
            last+=time;
        }
        return ans;
    }
}
