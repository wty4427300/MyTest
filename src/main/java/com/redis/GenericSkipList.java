package com.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 跳表的实现
 *
 * @param <T> 数据类型
 */
public class GenericSkipList<T extends Comparable<T>> {
    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    static class Node<T> {
        private T data;
        /**
         * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
         * forwards[3]表示当前节点在第三层的下一个节点。
         */
        private final Node<T>[] forwards;

        @SuppressWarnings("unchecked")
        public Node(int level) {
            forwards = new Node[level];
        }
    }

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    /**
     * 带头链表
     */
    private final Node<T> head = new Node<>(MAX_LEVEL);
    private final Random r = new Random();

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void insert(T value) {
        //1. 随机当前节点的层数
        int level = head.forwards[0] == null ? 1 : this.randomLevel();
        //2. 如果随机的层数大于当前跳表的层数，就将跳表的层数加1
        if (level > levelCount) {
            level = ++levelCount;
        }
        //3. 创建新的节点，记录当前节点数据和层数,并初始化我的下层节点数组
        Node<T> newNode = new Node<>(level);
        newNode.data = value;
        //4. 从最高层开始查找当前节点的前一节点
        Node<T> p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data.compareTo(value) < 0) {
                //如果当前层的下一个节点小于当前节点，就继续向后查找
                p = p.forwards[i];
            }
            //5. 将当前节点插入到前一节点的后面，同时在当前层记录下一个节点
            if (level > i) {
                if (p.forwards[i] == null) {
                    // 如果前一节点的下一个节点为空，就将当前节点插入到前一节点的后面
                    p.forwards[i] = newNode;
                } else {
                    // 如果前一节点的下一个节点不为空，就将当前节点插入到前一节点和下一个节点之间
                    Node<T> next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void delete(T value) {
        // 1. 查找当前(需要删除)节点的前一节点，记录在 update 数组中
        List<Node<T>> update = new ArrayList<>(levelCount);
        Node<T> p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data.compareTo(value) < 0) {
                // 如果当前层的下一个节点小于当前节点，就继续向后查找
                p = p.forwards[i];
            }
            // 将前一节点记录在 update 数组中
            update.add(i, p);
        }

        // 2. 如果前一节点的下一个节点是目标节点，就从每层删除目标节点
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update.get(i).forwards[i] != null && update.get(i).forwards[i].data == value) {
                    // 将前一节点的下一个节点指向目标节点的下一个节点，从而删除目标节点
                    update.get(i).forwards[i] = update.get(i).forwards[i].forwards[i];
                }
            }
        }
    }

    public Node<T> find(T value) {
        Node<T> p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data.compareTo(value) < 0) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        GenericSkipList<Integer> list = new GenericSkipList<>();
        list.insert(1);
        list.insert(7);
        list.insert(3);
        list.insert(4);
        list.delete(7);
        Node<Integer> node = list.find(4);
        System.out.println("找到节点:" + node.data);
    }
}
