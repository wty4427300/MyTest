package com.algorithm;

import java.util.Arrays;

public class test2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        //降序
        Arrays.sort(idx,(a,b)->heights[b]-heights[a]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[idx[i]];
        }
        return ans;
    }
}
