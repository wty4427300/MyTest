package com.algorithm;

import java.util.*;

public class test2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        //寻找基因值为1的点
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i; // 出发点
                break;
            }
        }

        if (node < 0) { // 不存在基因值为 1 的点
            return ans;
        }

        // 建树
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parents[i]].add(i);
        }
        Set<Integer> vis = new HashSet<>();
        // 缺失的最小基因值
        int mex = 2;
        while (node >= 0) {
            this.dfs(node, g, vis, nums);
            // node 子树包含这个基因值
            while (vis.contains(mex)) {
                mex++;
            }
            // 缺失的最小基因值
            ans[node] = mex;
            // 往上走
            node = parents[node];
        }
        return ans;
    }

    private void dfs(int x, List<Integer>[] g, Set<Integer> vis, int[] nums) {
        vis.add(nums[x]); // 标记基因值
        for (int son : g[x]) {
            if (!vis.contains(nums[son])) {
                dfs(son, g, vis, nums);
            }
        }
    }
}
