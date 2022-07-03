package com.algorithm;

public class test556 {
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        //从后向前遍历
        int i = nums.length - 2;
        //得到第一个较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        //得到较大的数存在
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        //较小数交换较大数和--;
        this.swap(nums, i, j);
        this.reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        //如果不是32位整数也返回-1
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    /**
     * 数组的两个索引位交换
     */
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 降序数组,使用双指针交换,变成升序
     */
    public void reverse(char[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
