package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1377 {
    private double ans;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g=new ArrayList[n+1];
        Arrays.setAll(g,e->new ArrayList<>());
        //给节点1
        g[1].add(0);
        for (int[] e:edges){
            int x=e[0],y=e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(g,target,1,0,t,1);
        return ans;
    }

    private boolean dfs(List<Integer>[] g,int target,int x,int fa,int leftT, long prod){
        if (x==target &&(leftT==0||g[x].size()==1)){
            ans=1.0/prod;
            return true;
        }
        if (x==target||leftT==0){
            return false;
        }
        for (int y:g[x]){
            if (y!=fa &&dfs(g,target,y,x,leftT-1,prod*(g[x].size()-1))){
                return true;
            }
        }
        return false;
    }
}
