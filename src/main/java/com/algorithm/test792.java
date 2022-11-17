package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test792 {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int count = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        for (String word : words) {
            int len = word.length();
            boolean flag = true;
            int start = -1;
            for (int i = 0; i < len && flag; i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    flag = false;
                } else {
                    List<Integer> idx = map.get(c);
                    if (idx.isEmpty() || idx.get(idx.size() - 1) <= start) {
                        flag = false;
                        break;
                    }
                    start = this.binarySearch(idx, start);
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

}
