package com.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class test449 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    /**
     * 后序遍历
     */
    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        Integer val = stack.pop();
        TreeNode root = new TreeNode(val);
        //右节点>根节点
        root.right = construct(val, upper, stack);
        //左节点<根节点
        root.left = construct(lower, val, stack);
        return root;
    }
}
