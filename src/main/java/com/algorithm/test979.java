package com.algorithm;

public class test979 {

    private int ans;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int d=dfs(node.left)+dfs(node.right)+node.val-1;
        ans+=Math.abs(d);
        return d;
    }
}
