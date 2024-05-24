package com.algorithm;

import java.util.Arrays;

public class test1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] st = new int[k];
        int m = 0; // 栈的大小
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (m > 0 && x < st[m - 1] && m + n - i > k) {
                m--;
            }
            if (m < k) {
                st[m++] = x;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        int[] nums={3,5,2,6};
        test1673 test1673=new test1673();
        int[] ints = test1673.mostCompetitive(nums, 2);
        System.out.println(Arrays.toString(ints));
    }
}
