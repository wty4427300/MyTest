package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 无向图
 */
public class Graph {
    private int v;
    private ArrayList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * s起始顶点
     * t终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //visited用来记录已经被访问的顶点,避免顶点的重复访问
        boolean[] visited = new boolean[v];
        //queue用来存储已经访问过,但是相连的顶点没被访问过的顶点
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        //记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        return;
                    }
                }
                visited[q] = true;
                queue.add(q);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    boolean found=false;

    public void dfs(int s,int t){
        found=false;
        boolean[] visited=new boolean[v];
    }
}
