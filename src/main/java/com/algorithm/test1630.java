package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> subList = Arrays.stream(nums).boxed().collect(Collectors.toList()).subList(l[i], r[i] + 1);
            List<Integer> collect = subList.stream().sorted().collect(Collectors.toList());
            boolean arithmetic = this.isArithmetic(collect);
            ans.add(arithmetic);
        }
        return ans;
    }

    public boolean isArithmetic(List<Integer> list) {
        if (list.size() < 2) {
            return true;
        }
        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != diff) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArray);
            int diff = subArray[1] - subArray[0];
            boolean arithmetic = true;
            for (int j = 2; j < subArray.length; j++) {
                if (subArray[j] - subArray[j - 1] != diff) {
                    arithmetic = false;
                    break;
                }
            }
            ans.add(arithmetic);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        test1630 test1630 = new test1630();
        List<Boolean> booleans = test1630.checkArithmeticSubarrays(nums, l, r);
        System.out.println(booleans);
    }
}
