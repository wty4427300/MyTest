package com.algorithm;

import java.util.TreeSet;

public class test2336 {
}

class SmallestInfiniteSet {
    private int thres;
    private final TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        thres = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            thres++;
            return ans;
        }
        return set.pollFirst();
    }

    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }
}
