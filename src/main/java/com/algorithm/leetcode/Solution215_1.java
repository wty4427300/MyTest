package com.algorithm.leetcode;

class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    private int quickSort(int[] nums, int l, int r, int k)
    {
        if (l >= r) {
            return nums[l];
        }
        int i = l - 1, j = r + 1;
        int x = nums[l + r >> 1];
        while(i < j)
        {
            do {
                i ++;
            } while (nums[i] < x);
            do {
                j --;
            } while (nums[j] > x);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        // // r - j + 1 > k    说明目标数值在右半边，并且不包含j
        // if (r - j >= k) return quickSort(nums, j + 1, r, k);
        // // r - j + 1 <= k    说明目标数值在左半边,可能就是 j ，所以要包含
        // return quickSort(nums, l, j, k - r + j);

        // 说明目标数值在右半边，并且不包含j
        if (j < nums.length - k) {
            return quickSort(nums, j + 1, r, k);
        }
        // 说明目标数值在左半边,可能就是 j ，所以要包含
        return quickSort(nums, l, j, k);
    }
    private void swap(int[] nums, int a, int b)
    {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
