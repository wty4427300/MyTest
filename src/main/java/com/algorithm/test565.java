package com.algorithm;

public class test565 {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            //因为元素大小为0到n-1
            while (nums[i] < n) {
                int num = nums[i];
                //当前位置已经被遍历过了所以
                //做标记，当再次索引到当前位置的时候
                //会因为条件不成立跳出循环
                nums[i] = n;
                i = num;
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        test565 t = new test565();
        int[] arr = {5, 4, 0, 3, 1, 6, 2};
        t.arrayNesting(arr);
    }
}
