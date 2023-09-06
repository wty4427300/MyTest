package com.algorithm;

public class test1123 {

    private TreeNode ans;
    private int maxDepth = -1; // 全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            //维护全局最大深度
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        //获取左子树最深叶节点的深度
        int leftMaxDepth = dfs(root.left, depth + 1);
        //获取右子树最深叶节点的深度。
        int rightMaxDepth = dfs(root.right, depth + 1);
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) {
            ans = root;
        }
        return Math.max(leftMaxDepth, rightMaxDepth); // 当前子树最深叶节点的深度
    }
}
