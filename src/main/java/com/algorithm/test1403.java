package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        //从最大的数开始取
        int sum = 0, cur = 0, idx = nums.length - 1;
        //总和
        for (int i : nums) {
            sum += i;
        }
        List<Integer> ans = new ArrayList<>();
        while (cur <= sum) {
            sum -= nums[idx];
            cur += nums[idx];
            ans.add(nums[idx--]);
        }
        //降序输出
        return ans;
    }
}
