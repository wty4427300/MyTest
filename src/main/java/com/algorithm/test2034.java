package com.algorithm;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {
    private final Map<Integer, Integer> d = new HashMap<>();
    private final TreeMap<Integer, Integer> ls = new TreeMap<>();
    private int last;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if (d.containsKey(timestamp)) {
            Integer o = d.get(timestamp);
            if (ls.merge(o, -1, Integer::sum) == 0) {
                ls.remove(o);
            }
        }
        d.put(timestamp, price);
        ls.merge(price, 1, Integer::sum);
        last = Math.max(last, timestamp);
    }

    public int current() {
        return d.get(last);
    }

    public int maximum() {
        return ls.lastKey();
    }

    public int minimum() {
        return ls.firstKey();
    }
}

public class test2034 {
}
