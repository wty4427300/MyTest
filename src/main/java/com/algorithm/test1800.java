package com.algorithm;

public class test1800 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //升序
            if (nums[i - 1] < nums[i]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
