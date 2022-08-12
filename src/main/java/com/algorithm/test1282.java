package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //将大小相同的下标放在一起
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            map.put(groupSizes[i], orDefault);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            List<Integer> integers = map.get(k), cur = new ArrayList<>();
            for (Integer integer : integers) {
                cur.add(integer);
                if (cur.size() == k) {
                    //如果数组容量满了,则穿件一个新的数组
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}
