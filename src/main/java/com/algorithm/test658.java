package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        }).collect(Collectors.toList());
        List<Integer> integers = list.subList(0, k);
        Collections.sort(integers);
        return integers;
    }
}
