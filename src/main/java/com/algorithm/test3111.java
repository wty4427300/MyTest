package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class test3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int result=0;
        int bound=-1;
        for (int[] p:points){
            if (p[0]>bound){
                bound=p[0]+w;
                result++;
            }
        }
        return result;
    }
}
