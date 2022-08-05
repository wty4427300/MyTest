package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class test623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //深度为1则添加的节点为root节点
        if (depth == 1) {
            TreeNode ans = new TreeNode();
            ans.val = val;
            ans.left = root;
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int cur = 1;
        while (!deque.isEmpty()) {
            //遍历当前层级
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val);
                    TreeNode b = new TreeNode(val);
                    a.left = node.left;
                    b.right = node.right;
                    node.left = a;
                    node.right = b;
                } else {
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
            }
            cur++;
        }
        return root;
    }
}
