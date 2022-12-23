package com.test;

import java.util.LinkedList;

/**
 * lru的简单实现
 */
public class test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        test.lru(1,linkedList);
        test.lru(2,linkedList);
        test.lru(3,linkedList);
        test.lru(4,linkedList);
        test.lru(2,linkedList);
        for (int a:linkedList){
            System.out.println(a);
        }
        int a=16;
        int b=a/10;
        System.out.println(b);
    }
    public static void lru(Integer i,LinkedList<Integer> linkedList){
        if (linkedList.size()==0){
            linkedList.addFirst(i);
        } else {
            for (Integer a : linkedList) {
                if (a.equals(i)) {
                    //如果存在就删除这个节点
                    linkedList.remove(a);
                    //并把这个元素移动到开头
                    linkedList.addFirst(i);
                    break;
                } else {
                    //如果不存在
                    if (linkedList.size() <= 10) {
                        //还有内存的情况下，直接添加在开头
                        linkedList.addFirst(i);
                        break;
                    } else {
                        //内存不足的情况下
                        //删除最后一个节点
                        linkedList.removeLast();
                        //并添加到开头
                        linkedList.addFirst(i);
                        break;
                    }
                }

            }
        }
        }
}
