package com.algorithm;

import com.algorithm.base.TreeNode;

public class test337 {

    public int rob(TreeNode root) {
        int[] ans = this.dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[]{root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }

    public static void main(String[] args) {
        Integer[] data = {4, 1, null, 2, null, 3};
        TreeBuilder builder = new TreeBuilder();
        TreeNode root = builder.buildTree(data);
        test337 test337 = new test337();
        int rob = test337.rob(root);
        System.out.println(rob);
    }
}
