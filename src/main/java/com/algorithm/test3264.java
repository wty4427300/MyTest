package com.algorithm;

import java.util.Arrays;

public class test3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int min = nums[0], minIndex = 0;
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                } else if (nums[i] == min) {
                    if (i < minIndex) {
                        minIndex = i;
                    }
                }
            }
            int res = nums[minIndex] * multiplier;
            nums[minIndex] = res;
            min = res;
        }
        return nums;
    }

    public int[] getFinalState1(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int m = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[m]) {
                    m = j;
                }
            }
            nums[m] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        test3264 test3264 = new test3264();
        int[] nums = {5, 3, 1, 1};
        int[] finalState = test3264.getFinalState(nums, 4, 3);
        System.out.println(Arrays.toString(finalState));
    }
}
