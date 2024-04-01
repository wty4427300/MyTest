package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

/**
 * 二叉树后序遍历，双栈实现
 */
public class test17 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            stack1.push(root);
        }
        while (!stack1.isEmpty()) {
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode);


            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        test17 traversal = new test17();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = traversal.postorderTraversal(root);
        System.out.println(result);  // 应输出：[4, 5, 2, 3, 1]
    }
}
