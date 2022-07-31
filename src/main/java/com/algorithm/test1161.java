package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class test1161 {
    /**
     * 层序遍历，求层序和，返回最大层序,非递归
     */
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        //层序号从1开始
        int max = Integer.MIN_VALUE, depth = 1, ans = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            //记录当前层级的节点数量开始累加
            int size = deque.size(), cur = 0;
            while (size-- > 0) {
                //查看并移除队列头的元素
                TreeNode node = deque.pollFirst();
                //并遍历子节点,累加当前层级的值
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                cur += node.val;
            }
            if (cur > max) {
                max = cur;
                ans = depth;
            }
            //每处理完一层层级+1；
            depth++;
        }
        return ans;
    }
}
