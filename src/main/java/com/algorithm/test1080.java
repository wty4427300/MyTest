package com.algorithm;

public class test1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return this.dfs(root, 0, limit) ? root : null;
    }

    public boolean dfs(TreeNode node,int sum,int limit){
        if (node==null){
            return false;
        }
        //左右节子点为null,则该节点是叶子节点
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }
        boolean haveSufficientLeft = dfs(node.left, sum + node.val, limit);
        boolean haveSufficientRight = dfs(node.right, sum + node.val, limit);
        if (!haveSufficientLeft) {
            node.left = null;
        }
        if (!haveSufficientRight) {
            node.right = null;
        }
        //如果有一个节点不是不足节点,则不需要删除该节点
        return haveSufficientLeft || haveSufficientRight;
    }
}
