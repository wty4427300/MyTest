package com.algorithm;

import com.algorithm.base.TreeNode;

public class test1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root,int pathMax){
        if (root==null){
            return 0;
        }
        int res=0;
        if (root.val>=pathMax){
            pathMax=root.val;
            res++;
        }
        res+=dfs(root.left,pathMax)+dfs(root.right,pathMax);
        return res;
    }
}
