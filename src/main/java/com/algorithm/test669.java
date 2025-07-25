package com.algorithm;

import com.algorithm.base.TreeNode;

public class test669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        if (root.val<low){
            return trimBST(root.right,low,high);
        }else if (root.val>high){
            return trimBST(root.left,low,high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
