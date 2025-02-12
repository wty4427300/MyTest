package com.algorithm;

import java.util.Arrays;

public class test1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().orElseThrow();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }

    public int minimumSize1(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().orElseThrow();
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAchieve(nums, mid, maxOperations)) {
                // 如果可以达到目标，则尝试更小的mid值
                ans = mid;
                right = mid - 1;
            } else {
                // 否则需要更大的mid值
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(int[] nums, int target, int maxOperations) {
        int operationsNeeded = 0;
        for (int num : nums) {
            if (num > target) {
                operationsNeeded += (num - 1) / target;
                if (operationsNeeded > maxOperations) {
                    return false;
                }
            }
        }
        return true;
    }
}
