package com.algorithm;

/**
 * 链表的节点
 */
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
/**
 * 剑指offer
 */
public class test_02_29 {
    public Node insert(Node head, int insertVal) {
        Node node=new Node(insertVal);
        //空链表
        if (head==null){
            //循环链表返回本身
            node.next=node;
            //自己就是头结点
            return node;
        }
        //只有一个节点
        if (head.next==head){
            //加入新节点
            head.next=node;
            node.next=head;
            return head;
        }
        Node curr=head,next=head.next;
        while (next!=head){
            if (insertVal>=curr.val && insertVal<=next.val){
                break;
            }
            //此时是头尾节点,curr最大,next最小
            if (curr.val>next.val){
                if (insertVal>curr.val || insertVal< next.val){
                    break;
                }
            }
            //不符合就不断向后移动节点
            curr=curr.next;
            next=next.next;
        }
        curr.next=node;
        node.next=next;
        return head;
    }
}
