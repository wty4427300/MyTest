package com.test;

import java.util.ArrayList;

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
}
