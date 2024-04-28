package com.algorithm;

import java.util.*;

public class test2385 {
    public int amountOfTime(TreeNode root, int start) {
        //邻接表
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //构建无向图
        dfs(graph, root);
        //广度遍历
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start,0});
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time=0;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int nodeVal=cur[0];
            time=cur[1];
            //遍历当前节点的邻接表
            for (int childVal:graph.get(nodeVal)){
                if(visited.add(childVal)){
                    queue.offer(new int[]{childVal,time+1});
                }
            }
        }
        return time;
    }

    public void dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
        graph.putIfAbsent(node.val, new ArrayList<>());
        for (TreeNode child: Arrays.asList(node.left,node.right)){
            if (child!=null){
                //构建无向图
                graph.get(node.val).add(child.val);
                graph.putIfAbsent(child.val,new ArrayList<>());
                graph.get(child.val).add(node.val);
                dfs(graph,child);
            }
        }
    }
}
