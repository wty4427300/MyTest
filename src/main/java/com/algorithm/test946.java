package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class test946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                j++;
                deque.pollLast();
            }
        }
        return deque.isEmpty();
    }
}
