package com.algorithm;

public class test275 {
    public int hIndex(int[] citations) {
        //n是论文总篇数
        int n = citations.length;
        //因为一定存在0篇论文引用0次,所以最小引用数从1开始
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (citations[n - mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1, 3, 5, 6};
        test275 test275 = new test275();
        int ans = test275.hIndex(citations);
        System.out.println(ans);
    }
}
