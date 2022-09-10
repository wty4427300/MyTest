package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class test1475 {

    public int[] finalPrices(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j = 0; j < prices.length; j++) {
            //满足条件的最小下标,即面足条件的第一个值
            while (!deque.isEmpty() && prices[deque.peekLast()] >= prices[j]) {
                int i = deque.pollLast();
                prices[i] = prices[i] - prices[j];
            }
            //保存数组索引
            deque.addLast(j);
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 2, 3};
        test1475 test1475 = new test1475();
        test1475.finalPrices(arr);
    }
}
