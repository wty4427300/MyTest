package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (char c : suits) {
            set.add(c);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        if (map.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
