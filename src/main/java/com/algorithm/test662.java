package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test662 {

    public Map<Integer, Integer> map = new HashMap<>();
    public int ans;

    public int widthOfBinaryTree(TreeNode root) {
        this.dfs(root,1,0);
        return ans;
    }

    public void dfs(TreeNode root,int u,int depth){
        if (root==null){
            return;
        }
        if (!map.containsKey(depth)){
            //记录每层的第一个节点序号
            map.put(depth,u);
        }
        ans=Math.max(ans,u-map.get(depth)+1);
        dfs(root.left,u<<1,depth+1);
        dfs(root.right,u<<1|1,depth+1);
    }

    public static void main(String[] args) {
        int u = 2;
        int u1 = u << 1;
        int u2 = u1 | 1;
        System.out.println(u1);
        System.out.println(u2);
    }
}
