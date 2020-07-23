package com.ftest.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Tree {
    /**
     * @param root
     * @return 前序遍历
     */
    public List<Integer> preorder(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            //因为是前序遍历所以顺序是根左右,又因为栈是先进后出,所以右节点先进
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    /**
     * @param root
     * @return 树的中序遍历
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        //因为中序遍历的顺序是左根右，所以我们先遍历左子树，并按照左中右的顺序输出节点，当左子树遍历完了该出站的就是根节点了，当我们输出完根节点之后就应该遍历右子树了，然后右子树也按照左中右遍历即可
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                //中序遍历的顺序是,左根右,然后栈又是先进后出，所以我先把左子树加入到堆里面
                stack.push(curr);
                //顺着左子树一直迭代下去,直到找到最左子节点
                curr = curr.left;
            }
            //pop不只是返回当前的元素,还把元素弹出站了
            curr = stack.pop();
            list.add(curr.val);
            //开始迭代右子树
            curr = curr.right;
        }
        return list;
    }

    /**
     * @param root
     * @return 后序遍历
     */
    public List<Integer> postorder(TreeNode root) {
        //这个还是基于栈的方式。list用来存结果，stack用来存子树
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return list;
        }

        //如果根节点不为空
        stack.add(root);
        //开始遍历
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            //这里使用头插法,因为后序的顺序是左右根,所以我先把根插进去，这样后面有可以插入的节点就一定会插入在根的前面
            list.addFirst(node.val);
            //因为栈是先进后出的，我们的便利顺序又要保证，左右根，这样做子树先进去，就后出来，然后我们使用的又是头插法，所以后出来的左子树反而会排在最前面。
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return list;
    }

    /**
     * @param root
     * @return bfs层级遍历
     */
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
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
