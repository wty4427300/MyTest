package com.ftest.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class tree144 {
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
    public List<Integer> inner(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        //因为中序遍历的顺序是左根右，所以我们先遍历左子树，并按照左中右的顺序输出节点，当左子树遍历完了该出站的就是根节点了，当我们输出完根节点之后就应该遍历右子树了，然后右子树也按照左中右遍历即可
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                //中序遍历的顺序是,左根右,然后栈又是先进后出，所以我先把左子树加入到堆里面
                stack.push(curr);
                //顺着左子树一直迭代下去,直到找到最左子节点
                curr=curr.left;
            }
            //pop不只是返回当前的元素,还把元素弹出站了
            curr=stack.pop();
            list.add(curr.val);
            //开始迭代右子树
            curr=curr.right;
        }
        return list;
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
