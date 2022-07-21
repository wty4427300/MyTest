package com.algorithm;

public class test814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return null;
        }
        //先处理子节点
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        //不是叶子节点
        if (root.left!=null || root.right!=null){
            return root;
        }
        //是叶子节点且
        return root.val==0?null:root;
    }

}
