package com.algorithm;

public class test1038 {
    private int s = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public void  dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.right);
        s+=node.val;
        node.val=s;
        dfs(node.left);
    }
}
