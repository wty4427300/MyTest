package com.algorithm;

import com.algorithm.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class test515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //深度
        this.dfs(res, root, 0);
        //广度
        this.bfs(res,root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {
            res.add(root.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        //递归左子树
        if (root.left != null) {
            dfs(res, root.left, curHeight + 1);
        }
        //递归右子树
        if (root.right != null) {
            dfs(res, root.right, curHeight + 1);
        }
    }

    /**
     * poll：将首个元素从队列中弹出，如果队列是空的，就返回null
     * peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
     * element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
     */
    public void bfs(List<Integer> res, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxVal = Integer.MIN_VALUE;
            while (len > 0) {
                len--;
                TreeNode t = queue.poll();
                maxVal = Math.max(maxVal, t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(maxVal);
        }
    }
}
