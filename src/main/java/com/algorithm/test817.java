package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class test817 {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }
}
