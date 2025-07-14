package com.algorithm;

import com.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test508 {
    Map<Integer,Integer> cnt=new HashMap<>();
    int maxCnt=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:cnt.entrySet()){
            int k=entry.getKey(),v=entry.getValue();
            //把所有出现次数最大的元素和都放进去
            if (v==maxCnt){
                list.add(k);
            }
        }
        //做个类型转换
        int[] ans=new int[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    /**
     * 深度遍历树
     * @param node
     * @return
     */
    public int dfs(TreeNode node){
        if (node==null){
            return 0;
        }
        int sum=node.val+dfs(node.left)+dfs(node.right);
        cnt.put(sum,cnt.getOrDefault(sum,0)+1);
        //比较出现次数最多的元素和
        maxCnt=Math.max(maxCnt,cnt.get(sum));
        return sum;
    }
}
