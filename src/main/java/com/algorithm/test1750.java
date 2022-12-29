package com.algorithm;

import java.util.Arrays;
import java.util.List;

public class test1750 {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            //判断左边相同的字符串
            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) {
                l++;
            }
            //判断右边相同的字符串
            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) {
                r--;
            }
            l++;
            r--;
        }
        return r - l + 1;
    }

    public int minimumLength1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }
            while (left <= right && s.charAt(right) == c) {
                right--;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2,3,4,5,6,7,8,9,10);
        integers.stream().forEach(it->{
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(it);
        });
        integers.stream().parallel().forEach(System.out::println);
    }
}
