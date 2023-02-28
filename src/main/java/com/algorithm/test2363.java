package com.algorithm;

import akka.util.Collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>(1000);
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        return map.entrySet().stream()
                .map(e -> Arrays.asList(e.getKey(), e.getValue()))
                .sorted(Comparator.comparingInt(a -> a.get(0)))
                .collect(Collectors.toList());
    }


    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        return map.entrySet().stream()
                .map(e -> Arrays.asList(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] items1 = new int[][]{{1, 1}, {4, 5}, {3, 8}}, items2 = {{3, 1}, {1, 5}};
        test2363 test2363 = new test2363();
        List<List<Integer>> lists = test2363.mergeSimilarItems(items1, items2);
        System.out.println(lists);
    }
}
