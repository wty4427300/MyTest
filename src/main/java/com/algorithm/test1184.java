package com.algorithm;

public class test1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int sum1=0,sum2=0;
        for (int i=0;i<distance.length;i++){
            if (i>=start && i<destination){
                sum1+=distance[i];
            }else {
                sum2+=distance[i];
            }
        }
        return Math.min(sum1,sum2);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        test1184 test1184=new test1184();
        int result = test1184.distanceBetweenBusStops(arr, 0, 3);
        System.out.println(result);
    }
}

