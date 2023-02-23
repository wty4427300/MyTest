package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        test1238 test1238=new test1238();
        List<Integer> integers = test1238.circularPermutation(2, 3);
        System.out.println(integers);
        List<String> list = integers.stream().map(
                Integer::toBinaryString
        ).collect(Collectors.toList());
        System.out.println(list);
    }
}
