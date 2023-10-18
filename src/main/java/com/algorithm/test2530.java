package com.algorithm;

import java.util.PriorityQueue;

public class test2530 {
    public long maxKelements(int[] nums, int k) {
        //优先队列构建大顶堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int x = q.poll();
            ans += x;
            q.offer((x + 2) / 3);
        }
        return ans;
    }
}
