package com.algorithm;

import com.algorithm.base.ListNode;

public class test24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode newHead=head.next;
        head.next = swapPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }
}
