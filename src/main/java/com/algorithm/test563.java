package com.algorithm;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

/**
 * 先把节点的处理写出来,然后在写树的递归逻辑
 * 有一种逻辑分离的感觉
 */
public class test563 {

    public int findTilt(TreeNode root) {
        //无节点坡度为0
        if (root == null) {
            return 0;
        }
        //递归调用
        return findTilt(root.left) + findTilt(root.right) + Math.abs(getSum(root.left) - getSum(root.right));
    }

    int getSum(TreeNode root) {
        if (root == null) return 0;
        //左节点+右节点加+本节点的值
        return getSum(root.right) + getSum(root.left) + root.val;
    }

    /**
     * 以为每个节点都有自己的坡度,所以我只需要在遍历的时候计算每个节点的坡度并且累加起来就好
     */
    int ans;

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //获取权重值
        int l = dfs(root.left);
        int r = dfs(root.right);
        //计算坡度并累加
        ans += Math.abs(l - r);
        //每个子节点的权重值=本节点的val+r的权重值+l权重值
        return l + r + root.val;
    }
}
