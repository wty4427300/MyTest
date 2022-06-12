package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26], vis = new int[26];
        Arrays.stream(words).forEach(
                s -> {
                    //每次匹配之前初始化两个数组
                    //填充map为-1
                    Arrays.fill(map, -1);
                    //填充vis为0
                    Arrays.fill(vis, 0);
                    boolean ok = true;
                    for (int i = 0; i < pattern.length() && ok; i++) {
                        int c1 = s.charAt(i) - 'a';
                        int c2 = pattern.charAt(i) - 'a';
                        //字母还没有映射
                        if (map[c1] == -1 && vis[c2] == 0) {
                            map[c1] = c2;
                            vis[c2] = 1;
                        } else if (map[c1] != c2) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        ans.add(s);
                    }
                }
        );
        return ans;
    }

    public static void main(String[] args) {
        test890 test890 = new test890();
        String[] w = {"mee", "aqq"};
        String p = "abb";
        test890.findAndReplacePattern(w, p);
    }
}
