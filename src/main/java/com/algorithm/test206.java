package com.algorithm;

import com.algorithm.base.ListNode;

public class test206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        test206 leed2o6 = new test206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode result = leed2o6.reverseList(listNode1);
        while (true) {
            if (result != null) {
                System.out.println(result.val);
                result = result.next;
            }
        }
    }
}
