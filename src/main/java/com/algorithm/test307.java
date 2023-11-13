package com.algorithm;

public class test307 {

}

class NumArray {
    private final int[] tree;
    private final int[] nums;

    //x的最低非零位
    //例子1100 & 0100 =0100
    int lowBit(int x) {
        return x & -x;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public NumArray(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    private int prefixSum(int index){
        int sum=0;
        while (index>0){
            sum+=tree[index];
            index-=lowBit(index);
        }
        return sum;
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}