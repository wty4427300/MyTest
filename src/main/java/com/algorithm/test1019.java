package com.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class test1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        //遍历链表
        for (; head != null; head = head.next) {
            nums.add(head.val);
        }
        //栈
        Deque<Integer> stk = new ArrayDeque<>();
        int n = nums.size();
        int[] ans = new int[n];
        //倒序压栈
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums.get(i)) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(nums.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(2);
        ListNode node1=new ListNode(1);
        node.next=node1;
        ListNode node2=new ListNode(5);
        node1.next=node2;
        test1019 test1019=new test1019();
        test1019.nextLargerNodes(node);
    }
}
