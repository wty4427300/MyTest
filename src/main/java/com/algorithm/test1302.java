package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class test1302 {
    //深度遍历的解法
    class Solution {
        int maxLevel = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        public void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = node.val;
            } else if (level == maxLevel) {
                sum += node.val;
            }
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }
    }

    //层级遍历解法
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        int depth=0;
        deque.add(root);
        while (!deque.isEmpty()){
            int sz= deque.size();
            while (sz-->0){
                TreeNode node= deque.pollFirst();
                assert node != null;
                map.put(depth,map.getOrDefault(depth,0)+node.val);
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            depth++;
        }
        return map.get(depth-1);
    }
}
