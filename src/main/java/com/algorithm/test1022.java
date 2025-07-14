package com.algorithm;

import com.algorithm.base.TreeNode;

public class test1022 {
    public int sumRootToLeaf(TreeNode root) {
        return this.dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        //当前节点的二进制值=父节点左移一位|当前节点的值
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
