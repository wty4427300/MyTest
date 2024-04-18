package com.algorithm;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.IntStream;

public class test2007 {
    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        //长度为奇数一定不是一个双倍数组
        if (length % 2 == 1) {
            return new int[0];
        }
        //排序
        Arrays.sort(changed);
        HashMap<Integer, Integer> count = new HashMap<>();
        //统计词频
        for (int c : changed) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int[] res = new int[length / 2];
        int i = 0;
        for (int c : changed) {
            if (count.get(c) == 0) {
                continue;
            }
            //词频减去自己本身
            count.put(c, count.get(c) - 1);
            //任意一个两倍数不存在都不是双倍数组
            if (count.getOrDefault(c * 2, 0) == 0) {
                return new int[0];
            }
            count.put(c * 2, count.get(c * 2) - 1);
            res[i++] = c;
        }
        return res;
    }
}
