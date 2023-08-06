package com.Interview;

import java.util.*;

public class test13 {
    public Set<String> distinctSpecialString(List<String> specialStringList) {
        Set<String> result = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        for (String str : specialStringList) {
            String normalString = this.normalString(str);
            if (!map.containsKey(normalString)) {
                map.put(normalString, str);
                result.add(str);
            }
        }
        return result;
    }

    //使顺序不同的字符串相等
    private String normalString(String str) {
        String[] strs = str.split("_");
        Arrays.sort(strs);
        return String.join("_", strs);
    }

    public List<String> normalizeString(String str) {
        List<String> parts = new ArrayList<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c == '_') {
                parts.add(sb.toString());
                //清空StringBuilder
                sb.setLength(0);
            } else if (c == '\\') {
                sb.append(c);
                char nextChar = str.charAt(index + 1);
                if (nextChar == '_') {
                    // 跳过转义的下划线或斜杠
                    sb.append(nextChar);
                    index++;
                }
            } else {
                sb.append(c);
            }
            index++;
        }
        parts.add(sb.toString());
        //对parts进行排序并重新连接成标准化字符串
        Collections.sort(parts);
        return parts;
    }

    public static void main(String[] args) {
        List<String> specialStringList = Arrays.asList(
                "123_456_abc",
                "456_abc_123",
                "123_4_56_abc",
                "456_123_789",
                "789_123_456",
                "123_456\\_abc",
                "abc_456\\_123"
        );
        test13 processor = new test13();
        List<String> strings = processor.normalizeString(specialStringList.get(specialStringList.size() - 1));
        System.out.println(strings);
    }
}

