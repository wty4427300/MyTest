package com.algorithm;

import com.algorithm.base.TreeNode;

public class test2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
