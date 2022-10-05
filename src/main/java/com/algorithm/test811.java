package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(cpdomains).forEach(
                it -> {
                    String[] s = it.split(" ");
                    String[] nets = s[1].split("\\.");
                    StringBuilder str = new StringBuilder();
                    for (int i = nets.length - 1; i >= 0; i--) {
                        str.insert(0, ".").insert(0, nets[i]);
                        String key = str.substring(0, str.length() - 1);
                        Integer count = map.getOrDefault(key, 0);
                        map.put(key, count + Integer.parseInt(s[0]));
                    }
                }
        );
        return map.keySet().stream().map(
                url -> map.get(url) + " " + url).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        test811 test811 = new test811();
        String[] arr = new String[]{"9001 discuss.leetcode.com"};
        List<String> strings = test811.subdomainVisits(arr);
        System.out.println(strings);
    }
}
