package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class test1048 {

    private final Map<String, Integer> ws = new HashMap<>();

    public int longestStrChain(String[] words) {
        for (String s : words) {
            ws.put(s, 0);
        }
        int ans = 0;
        for (String s : ws.keySet()) {
            ans = Math.max(ans, dfs(s));
        }
        return ans;
    }

    public int dfs(String s) {
        int res = ws.get(s);
        if (res > 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            //每次减去一个字符
            String t = s.substring(0, i) + s.substring(i + 1);
            if (ws.containsKey(t)) {
                res = Math.max(res, dfs(t));
            }
        }
        //如果词链只有一个单词,那最长长度就是0+1=1,s本身是只有一个单词的词链
        int maxLength = res + 1;
        ws.put(s, maxLength);
        return maxLength;
    }

    public int longestStrChain1(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int maxChainLength = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            int chainLength = 1;
            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(pred)) {
                    chainLength = Math.max(chainLength, dp.get(pred) + 1);
                }
            }
            dp.put(word, chainLength);
            maxChainLength = Math.max(maxChainLength, chainLength);
        }
        return maxChainLength;
    }

    public int longestStrChain2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int ans = 0;
        Map<String, Integer> ws = new HashMap<>();
        for (String s : words) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(0, i) + s.substring(i + 1);
                res = Math.max(res, ws.getOrDefault(t, 0));
            }
            int maxLength = res + 1;
            ws.put(s, maxLength);
            ans = Math.max(ans, maxLength);
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
        test1048 test1048 = new test1048();
        test1048.longestStrChain(words);
    }
}
