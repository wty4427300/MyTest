package com.algorithm;

public class test2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                a = i;
            }
            if (nums[i] == n) {
                b = i;
            }
        }
        return a + n - 1 - b - ( b< a ? 1 : 0);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3};
        test2717 test2717 = new test2717();
        int i = test2717.semiOrderedPermutation(arr);
        System.out.println(i);
    }
}
