package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                //出现次数增加则原次数的元素数量-1
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            //该次数出现的元素数量+1
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            //三种情况
            //1.全部元素出现次数为1,删除任意一个元素即可
            boolean ok = maxFreq == 1 ||
                    //2.所有数的出现次数都是maxFreq 或 maxFreq−1，并且最大出现次数的数只有一个：删除一个最大出现次数的数
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    //3.其他数出现的次数都是maxFreq,只有一个数不同,且这个数只出现了一次,减去这个数就好
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                //前缀长度的=元素个数=下标+1
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
