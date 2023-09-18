package com.algorithm;

public class TreeBuilder {
    public TreeNode buildTree(Integer[] data) {
        return buildTree(data, 0);
    }

    private TreeNode buildTree(Integer[] data, int index) {
        if (index >= data.length || data[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(data[index]);
        node.left = buildTree(data, 2 * index + 1);
        node.right = buildTree(data, 2 * index + 2);

        return node;
    }
}
