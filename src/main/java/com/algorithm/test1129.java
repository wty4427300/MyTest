package com.algorithm;

import java.util.*;

public class test1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] next = new List[2][n];
        //二维数组的每一个元素是一个list
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<>();
            }
        }
        //red边的集合
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        //blue边的集合
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        //两种类型的颜色最短路径的长度
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        //红蓝从0开始长度都是0
        dist[0][0] = 0;
        dist[1][0] = 0;
        //从0开始是红
        queue.offer(new int[]{0, 0});
        //从0开始是蓝
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            //当前顶点和顶点的颜色
            int x = pair[0], t = pair[1];
            //取反色
            for (int y : next[1 - t][x]) {
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
