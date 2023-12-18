package com.test;

import java.util.*;

public class ArrayIntersectionExample {
    public static void main(String[] args) {
        String[][] twoDimensionalArray = {
                {"2023-11-27", "2023-11-28", "2023-11-29", "2023-11-30", "2023-12-01", "2023-12-02", "2023-12-03"},
                {"2023-12-04", "2023-12-05", "2023-12-06", "2023-12-07", "2023-12-08", "2023-12-09", "2023-12-10"},
                {"2023-12-11", "2023-12-12", "2023-12-13", "2023-12-14", "2023-12-15", "2023-12-16", "2023-12-17"},
                {"2023-12-18", "2023-12-19", "2023-12-20", "2023-12-21", "2023-12-22", "2023-12-23", "2023-12-24"},
                {"2023-12-25", "2023-12-26", "2023-12-27", "2023-12-28", "2023-12-29", "2023-12-30", "2023-12-31"}
        };

        String[] oneDimensionalArray = {
                "2023-12-01", "2023-12-02", "2023-12-03",
                "2023-12-04", "2023-12-05", "2023-12-06", "2023-12-07", "2023-12-08", "2023-12-09", "2023-12-10",
                "2023-12-11", "2023-12-12", "2023-12-13", "2023-12-14", "2023-12-17",
                "2023-12-18", "2023-12-19", "2023-12-21", "2023-12-22", "2023-12-23", "2023-12-24",
                "2023-12-25", "2023-12-26", "2023-12-27", "2023-12-28", "2023-12-29", "2023-12-30", "2023-12-31"
        };
        int n = twoDimensionalArray.length;
        List<List<int[]>> intersections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<int[]> result = findIntersections(twoDimensionalArray[i], oneDimensionalArray);
            intersections.add(result);
        }
        // 打印交集的连续时间段的开始和结束索引
        for (List<int[]> interval : intersections) {
            System.out.println("当前行重复索引位:");
            for (int[] index : interval) {
                System.out.println("开始索引：" + index[0] + "，结束索引：" + index[1]);
            }
        }
    }

    // 找到两个数组的交集
    private static List<int[]> findIntersections(String[] a, String[] b) {
        List<int[]> intersections = new ArrayList<>();

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int compareResult = a[i].compareTo(b[j]);

            if (compareResult == 0) {
                // 相等，找到了交集的开始位置
                int start = i;

                // 找到交集的结束位置
                while (i < a.length && j < b.length && a[i].compareTo(b[j]) == 0) {
                    i++;
                    j++;
                }

                int end = i - 1;

                // 将交集的开始和结束索引添加到结果列表中
                intersections.add(new int[]{start, end});
            } else if (compareResult < 0) {
                i++;
            } else {
                j++;
            }
        }

        return intersections;
    }
}
