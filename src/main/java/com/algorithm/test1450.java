package com.algorithm;

public class test1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans=0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime<=endTime[i]){
                ans+=1;
            }
        }
        return ans;
    }
}
