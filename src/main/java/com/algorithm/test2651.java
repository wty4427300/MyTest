package com.algorithm;

public class test2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int realTime = arrivalTime + delayedTime;
        if (realTime==24){
            return 0;
        }else if (realTime>24){
            return realTime-24;
        }
        return realTime;
    }
}
