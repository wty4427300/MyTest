package com.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

class NextNode {
    public int val;
    public NextNode left;
    public NextNode right;
    public NextNode next;

    public NextNode() {
    }

    public NextNode(int _val) {
        val = _val;
    }

    public NextNode(int val, NextNode left, NextNode right, NextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class test117 {
    public NextNode connect(NextNode root) {
        if (root==null){
            return null;
        }
        Queue<NextNode> queue = new ArrayDeque<NextNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            NextNode last=null;
            for(int i=1;i<=n;i++){
                NextNode f=queue.poll();
                if (f.left!=null){
                    queue.offer(f.left);
                }
                if (f.right!=null){
                    queue.offer(f.right);
                }
                if (i!=1){
                    last.next=f;
                }
                last = f;
            }
        }
        return root;
    }
}
