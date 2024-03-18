package com.algorithm;

import java.util.HashMap;
import java.util.Map;

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value, DLinkedNode prev, DLinkedNode next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}


public class test146 {

    class LRUCache {

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                node = new DLinkedNode(key, value, null, null);
                cache.put(key, node);
                addToHead(node);
                size++;
                if (size > capacity) {
                    DLinkedNode removedTail = removeTail();
                    cache.remove(removedTail.key);
                    size--;
                }
            } else {
                //更新当前节点的值
                node.value = value;
                moveToHead(node);
            }

        }

        private void addToHead(DLinkedNode node) {
            //需要放在伪节点得后面
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private DLinkedNode removeTail() {
            DLinkedNode prev = tail.prev;
            removeNode(prev);
            return prev;
        }

        private void moveToHead(DLinkedNode node) {
            //移除节点，并添加到头部
            removeNode(node);
            addToHead(node);
        }
    }

}
