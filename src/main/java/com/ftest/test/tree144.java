package com.ftest.test;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class tree144 {
    public List<Integer> preorder(TreeNode root){
        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<Integer> output=new LinkedList<>();
        if (root==null){
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pollLast();
            output.add(node.val);
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left!=null){
                stack.add(node.right);
            }
        }
        return output;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
