package com.algorithm;

import java.util.*;

public class test826 {
    /**
     * treemap版本，超时
     */
    public int maxProfitAssignment0(int[] difficulty, int[] profit, int[] worker) {
        //工作数量
        int n = difficulty.length;
        TreeMap<Integer, Integer> workProfitMap = new TreeMap<>();
        //初始化map key=difficulty value=profit，如果difficulty相同，保留最大的profit。
        for (int i = 0; i < n; i++) {
            workProfitMap.put(difficulty[i], Math.max(workProfitMap.getOrDefault(difficulty[i], 0), profit[i]));
        }
        //遍历工人
        int ans = 0;
        for (int j : worker) {
            //获取所有可以完成的工作
            NavigableMap<Integer, Integer> navigableMap = workProfitMap.headMap(j, true);
            if (!navigableMap.isEmpty()) {
                int maxProfit = 0;
                for (Map.Entry<Integer, Integer> entry : navigableMap.entrySet()) {
                    if (entry.getValue() > maxProfit) {
                        maxProfit = entry.getValue();
                    }

                }
                ans += maxProfit;
            }
        }
        return ans;
    }

    /**
     * 二维数组版本
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int ans = 0, j = 0, maxProfit = 0;
        for (int w : worker) {
            while (j < n && jobs[j][0] <= w) {
                maxProfit = Math.max(maxProfit, jobs[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] difficulty = {66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63};
        int[] profit = {66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77};
        int[] worker = {61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16};
        test826 test826 = new test826();
        int i = test826.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(i);
    }
}
