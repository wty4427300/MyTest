package com.test;

import java.util.HashMap;
import java.util.Map;

public class test16 {

    private Map<Character, Integer> findMaxChar(String s) {
        int maxCount = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        //遍历字符串统计次数
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int count;
            if (charCountMap.containsKey(curChar)) {
                count = charCountMap.get(curChar) + 1;
            } else {
                count = 1;
            }
            charCountMap.put(curChar, count);
            if (count > maxCount)
                maxCount = count;
        }
        //遍历map，找出出现次数最多的字符
        Map<Character, Integer> maxCharMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                maxCharMap.put(entry.getKey(), entry.getValue());
            }
        }
        return maxCharMap;
    }

    public static void main(String[] args) {
        test16 test16 = new test16();
        System.out.println(test16.findMaxChar("abbcdd"));
    }
}
