package com.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class test1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = knowledge.stream().collect(Collectors.toMap(list -> list.get(0), list -> list.get(1)));
        StringBuilder builder = new StringBuilder();
        int t = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                start = i + 1;
                t = 1;
            } else if (s.charAt(i) == ')' && t == 1) {
                builder.append(map.getOrDefault(s.substring(start, i), "?"));
                start = i;
                t = 0;
            } else {
                if (t == 0) {
                    builder.append(s.charAt(i));
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "(a)(a)(a)aaa";
        List<List<String>> knowledge = Collections.singletonList(Arrays.asList("a", "yes"));
        test1807 test1807 = new test1807();
        String evaluate = test1807.evaluate(s, knowledge);
        System.out.println(evaluate);
    }
}
