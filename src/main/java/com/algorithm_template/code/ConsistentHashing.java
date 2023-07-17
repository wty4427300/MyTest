package com.algorithm_template.code;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    private SortedMap<Integer, String> circle = new TreeMap<>();
    private List<String> nodes = new ArrayList<>();
    private final int numberOfReplicas = 3; // 虚拟节点的副本数

    /**
     * 计算hash值
     */
//    private int getHash(String key) {
//        final int prime = 31;
//        int hash = 0;
//        for (char c : key.toCharArray()) {
//            hash = prime * hash + c;
//        }
//        return hash;
//    }
//
//    private int getHash(String key) {
//        return key.hashCode();
//    }

    private int getHash(String key) {
        return ConsistentHashingHashFunction.hashCode(key);
    }

    public void addNode(String node) {
        nodes.add(node);
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = this.getHash(node + i);
            circle.put(hash, node);
        }
    }

    public void removeNode(String node) {
        nodes.remove(node);
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = this.getHash(node + i);
            circle.remove(hash);
        }
    }

    public String getNode(String key) {
        //没有可用节点直接返回
        if (circle.isEmpty()) {
            return null;
        }
        int hash = this.getHash(key);
        if (!circle.containsKey(hash)) {
            //hash环中不存在，说明没有映射到具体节点，于是去找大于等于该hash值的所有节点，即顺时针便利
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public static void main(String[] args) {
        ConsistentHashing test = new ConsistentHashing();

        // 添加模拟的物理节点
        test.addNode("192.168.0.1");
        test.addNode("192.168.0.2");
        test.addNode("192.168.0.3");

        // 模拟查找多个键的所属节点
        String[] keys = {"A-1", "He-2", "Oey-3", "ReyA-4", "YeyDF-5"};
        for (String key : keys) {
            String node = test.getNode(key);
            System.out.println("Key: " + key + " => Node: " + node);
        }

        // 模拟删除一个物理节点并重新查找所属节点
        test.removeNode("192.168.0.2");

        System.out.println("After removing Node 192.168.0.2:");
        for (String key : keys) {
            String node = test.getNode(key);
            System.out.println("Key: " + key + " => Node: " + node);
        }
    }
}
