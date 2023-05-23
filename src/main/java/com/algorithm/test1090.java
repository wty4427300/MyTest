package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        //降序排序每次取value大的,id用来记录元素之前的索引,方便获取value的label.
        Arrays.sort(id, (a, b) -> values[b] - values[a]);
        int ans=0,choose=0;
        //map用来记录当前label取了几个.
        Map<Integer,Integer> cnt=new HashMap<>();
        for (int i=0;i<n&& choose<numWanted;i++){
            int label=labels[id[i]];
            if (cnt.getOrDefault(label,0)==useLimit){
                continue;
            }
            choose++;
            ans+=values[id[i]];
            cnt.put(label,cnt.getOrDefault(label,0)+1);
        }
        return ans;
    }
}
