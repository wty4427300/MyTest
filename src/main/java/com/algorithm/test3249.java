package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test3249 {

    private int ans;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n];
        //将数组中的每个元素初始化一个ArrayList
        Arrays.setAll(g, i -> new ArrayList<>());
        //构建图
        for(int[] e:edges){
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1, g);
        return ans;
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int size = 1;
        int sz0 = 0;
        boolean ok=true;
        for (int y:g[x]){
            if (y==fa){
                continue;
            }
            int sz=dfs(y,x,g);
            if (sz0==0){
                sz0=sz;
            }else if (sz!=sz0){
                ok=false;
            }
            size+=sz;
        }
        ans+=ok ? 1 : 0;
        return size;
    }
}
