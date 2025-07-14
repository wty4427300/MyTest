package com.algorithm;

import com.algorithm.base.TreeNode;

public class test654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int best=left;
        //遍历一次记录最大值的索引位置
        for(int i=left+1;i<=right;++i){
            if (nums[i]>nums[best]){
                best=i;
            }
        }
        TreeNode node=new TreeNode(nums[best]);
        node.left=build(nums,left,best-1);
        node.right=build(nums,best+1,right);
        return node;
    }
}
