package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test318 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                //字母转数字
                int u = w.charAt(i) - 'a';
                //左移转化为对应位的1
                //和t进行合并,由于|是有有一个1就为1,所以会渲染之前是0的位
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m) {
                //词频相同的情况下,存储最长的长度
                map.put(t, m);
            }
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                //a & b说明没有任何一位有相同的字母,两个字符串不相等
                if ((a & b) == 0) {
                    ans = Math.max(ans, map.get(a) * map.get(b));
                }
            }
        }
        return ans;
    }
}
