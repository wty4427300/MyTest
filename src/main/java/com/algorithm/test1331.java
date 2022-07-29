package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] carr = new int[arr.length];
        System.arraycopy(arr, 0, carr, 0, arr.length);
        //排序完的数组
        Arrays.sort(carr);
        //k=元素,v=序号
        Map<Integer, Integer> ranks = new HashMap<>();
        int[] ans = new int[arr.length];
        //遍历保存排序完的序号
        for (int i : carr) {
            //为什么要判断是否存在
            //因为大小一样的元素序号相同
            if (!ranks.containsKey(i)) {
                //此时map的size从0开始
                //所以value从1开始递增
                ranks.put(i, ranks.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            //将数组的元素替换为序号并且保存在一个新数组里
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
