package com.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

public class test919 {

}

class CBTInserter {

    private Queue<TreeNode> candidate;
    private TreeNode root;

    /**
     * 层级遍历初始化工具类
     */
    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        //队尾插入元素
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            //有空的子节点则改节点可以插入
            //只存在右边空,或者左右都空的情况
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        String a = "{\"patientId\":22,\"source\":1}";
    }
}
