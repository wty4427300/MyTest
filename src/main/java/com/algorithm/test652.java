package com.algorithm;

import java.util.*;

public class test652 {
    public Map<String, TreeNode> seen = new HashMap<>();
    public Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.dfs(root);
        return new ArrayList<>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val)
                .append("(")
                .append(dfs(node.left))
                .append(")(")
                .append(dfs(node.right))
                .append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            //set保证重复子树只存一次
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }
}
