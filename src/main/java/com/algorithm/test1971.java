package com.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class test1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //初始化图
        List<Integer>[] adj=new List[n];
        for (int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }
        //遍历所有的边
        for (int[] edge:edges){
            int x=edge[0],y=edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(source);
        visited[source]=true;
        while (!queue.isEmpty()){
            int vertex=queue.poll();
            if (vertex==destination){
                break;
            }
            for (int next:adj[vertex]){
                if (!visited[next]){
                    queue.offer(next);
                    visited[next]=true;
                }
            }
        }
        return visited[destination];
    }
}