package com.algorithm;

public class test513 {

    int curVal=0;

    int curHeight=0;

    public int findBottomLeftValue(TreeNode root) {
        this.dfs(root,0);
        return curVal;
    }

    public void dfs(TreeNode node,int height){
        if (node==null){
            return;
        }
        height++;
        dfs(node.left,height);
        dfs(node.right,height);
        if (height>curHeight){
            curHeight=height;
            curVal=node.val;
        }
    }
}

