package com.algorithm;

/**
 * 目前的写法会导致树高度失衡，下次再优化
 */
public class test450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (key > root.val) {
            //删除右子树
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            //去左子树删除
            root.left = deleteNode(root.left, key);
        } else {
            // 当前节点就是要删除的节点
            if (root.left == null) {
                //欲删除节点无左子
                return root.right;
            } else if (root.right == null) {
                //欲删除节点无右子
                return root.left;
            } else {
                //欲删除节点左右子都有
                TreeNode node = root.right;
                //寻找欲删除节点右子树的最左节点
                //右子树所有的节点都大于本节点，右子树最左节点就是右子树中的最小节点
                while (node.left != null) {
                    node = node.left;
                }
                //将欲删除节点的左子树成为其右子树的最左节点的左子树
                node.left = root.left;
                //欲删除节点的右子顶替其位置，节点被删除，且二叉搜索性质不变
                root = root.right;
            }
        }
        return root;
    }
}

