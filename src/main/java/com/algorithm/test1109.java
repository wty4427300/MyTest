package com.algorithm;

import com.alibaba.fastjson.JSON;

public class test1109 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        //初始化一个数组
        int[] diff=new int[n+1];
        //每个bo都是从first到last每个班次有几个座位
        for (int[] bo:bookings){
            int l=bo[0]-1,r=bo[1]-1,v=bo[2];
            diff[l]+=v;
            diff[r+1]-=v;
        }
        int[] ans=new int[n];
        System.out.println(JSON.toJSONString(diff));
        ans[0]=diff[0];
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]+diff[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        corpFlightBookings(bookings,n);
    }
}
