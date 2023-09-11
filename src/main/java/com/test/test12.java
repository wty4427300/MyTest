package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test12 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int len = 0; len <= nums.length; len++) {
            backtrack(results, new ArrayList<>(), nums, 0, len);
        }
        return results;
    }

    private static void backtrack(List<List<Integer>> results, List<Integer> currSubset, int[] nums, int start, int len) {
        if (currSubset.size() == len) {
            results.add(new ArrayList<>(currSubset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currSubset.add(nums[i]);
            backtrack(results, currSubset, nums, i + 1, len);
            currSubset.remove(currSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3};
        List<List<Integer>> subsetsResult = subsets(inputArray);

        // Print the generated subsets
        for (List<Integer> subset : subsetsResult) {
            System.out.println(subset);
        }
    }
}
