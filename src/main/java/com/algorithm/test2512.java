package com.algorithm;

import java.util.*;

public class test2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        //初始化评语的的分
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }
        for (String word : negative_feedback) {
            words.put(word, -1);
        }
        int n = report.length;
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String w : report[i].split(" ")) {
                score += words.getOrDefault(w, 0);
            }
            //学生的分,以及对应的分数负数.这样最大分就变成了最小分
            result[i] = new int[]{-score, student_id[i]};
        }
        //按照分数从小到大排序,分数相同id小的在前面
        Arrays.sort(result, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //取前k个得到结果
        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(result[i][1]);
        }
        return topK;
    }
}
