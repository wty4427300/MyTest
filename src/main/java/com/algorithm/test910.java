package com.algorithm;

import java.util.Arrays;

public class test910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int mi = nums[0], ma = nums[nums.length - 1];
        int res = ma - mi;
        for (int i = 0; i < nums.length - 1; i++) {
            //因为排序后一定是a小b大
            int a = nums[i], b = nums[i + 1];
            res = Math.min(res, Math.max(ma - k, a + k) - Math.min(mi + k, b - k));
        }
        return res;
    }
}
