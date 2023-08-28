package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l=newInterval[0];
        int r=newInterval[1];
        boolean placed=false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] ints:intervals){
            if (ints[0]>r){
                if (!placed){
                    ansList.add(new int[]{l,r});
                    placed=true;
                }
                ansList.add(ints);
            }else if(ints[1]<l){
                ansList.add(ints);
            }else {
                l=Math.min(l,ints[0]);
                r=Math.max(r,ints[1]);
            }
        }
        if (!placed){
            ansList.add(new int[]{l, r});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
