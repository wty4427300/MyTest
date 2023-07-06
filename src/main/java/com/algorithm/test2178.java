package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return result;
        }
        for (long i = 2; i <=finalSum; i += 2) {
            result.add(i);
            finalSum -= i;
        }
        result.set(result.size() - 1, result.get(result.size() - 1) + finalSum);
        return result;
    }
}
