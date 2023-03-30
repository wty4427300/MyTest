package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class test1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans=0;
        for (int i=0;i<points.length-1;i++){
            ans=Math.max(ans,points[i+1][0]-points[i][0]);
        }
        return ans;
    }
}
