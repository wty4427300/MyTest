package com.algorithm;

import java.util.*;

public class test1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Arrays.stream(logs).forEach(
                it -> {
                    map.putIfAbsent(it[0], new HashSet<Integer>());
                    map.get(it[0]).add(it[1]);
                }
        );
        int[] ans = new int[k];
        for (Set<Integer> minutes : map.values()) {
            int activeCount = minutes.size();
            //下标从1开始
            ans[activeCount - 1]++;
        }
        return ans;
    }
}
