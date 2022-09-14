package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ds = new double[n][2];
        for (int i = 0; i < n; i++) {
            ds[i][0] = wage[i] * 1.0 / quality[i];
            ds[i][1] = i * 1.0;
        }
        Arrays.sort(ds, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        double ans = 1e18;
        for (int i = 0, tot = 0; i < n; i++) {
            int cur = quality[(int) ds[i][1]];
            tot += cur;
            q.add(cur);
            if (q.size() > k) {
                tot -= q.poll();
            }
            if (q.size() == k) {
                //总工作质量*工资比例=实际工资
                ans = Math.min(ans, tot * ds[i][0]);
            }
        }
        return ans;
    }
}
