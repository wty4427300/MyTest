package com.algorithm;

public class test687 {

    public int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        this.dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dfsLeft = dfs(root.left);
        int dfsRight = dfs(root.right);
        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = dfsLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = dfsRight + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }

}
