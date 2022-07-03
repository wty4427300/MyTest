package com.algorithm;

public class test31 {

    public void nextPermutation(int[] nums) {
        //从后向前遍历
        int i = nums.length - 2;
        //得到第一个较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //得到较大的数存在
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //较小数交换较大数和--;
            this.swap(nums, i, j);
        }
        //当i<0,说明当前序列就是最大序列,只需要降序排序即可
        reverse(nums, i + 1);
    }

    /**
     * 数组的两个索引位交换
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 降序数组,使用双指针交换,变成升序
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
