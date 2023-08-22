package com.algorithm;

public class test849 {
    public int maxDistToClosest(int[] seats) {
        int ans = 0, l = 0;
        while (l < seats.length && seats[l] == 0) {
            l++;
        }
        ans = Math.max(ans, l);
        while (l < seats.length) {
            int r = l + 1;
            while (r < seats.length && seats[r] == 0) {
                r++;
            }
            if (r == seats.length) {
                ans = Math.max(ans, r - l - 1);
            } else {
                ans = Math.max(ans, (r - l) / 2);
            }
            l = r;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        test849 test849 = new test849();
        int i = test849.maxDistToClosest(seats);
        System.out.println(i);
    }
}
