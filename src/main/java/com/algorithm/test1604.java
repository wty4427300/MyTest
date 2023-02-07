package com.algorithm;

import java.util.*;

public class test1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            //时间转分钟
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);
            //三个时间段内间隔<=60分钟
            for (int i = 2; i < list.size(); i++) {
                int start = list.get(i - 2), end = list.get(i);
                int difference = end - start;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
