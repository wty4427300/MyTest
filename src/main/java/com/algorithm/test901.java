package com.algorithm;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class StockSpanner {

    private final Deque<int[]> stack = new ArrayDeque<>();
    private int curDay = -1;

    public StockSpanner() {
        // 这样无需判断栈为空的情况
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = ++curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }
}

public class test901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        stockSpanner.next(75);
    }
}
