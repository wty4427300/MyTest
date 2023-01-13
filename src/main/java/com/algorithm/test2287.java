package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        int n = s.length(), m = target.length();
        //统计target次数
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        //统计s次数
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (targetMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sMap.getOrDefault(c, 0);
            //组成最大副本数为数量最少的那个字符,即木桶的最短板
            ans = Math.min(ans, totalCount / count);
            //有一个字符不存在就无法组成
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }
}
