package com.algorithm;

public class test801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        //n行2列的二维数组
        int[][] f=new int[n][2];
        for(int i=1;i<n;i++){
            f[i][0]=f[i][1]=n+10;
        }
        f[0][1]=1;
        for (int i=1;i<n;i++){
            //i,i-1可以 都换 或者 都不换,因为已经是递增的了
            if (nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            //i,i - 1 只能有其一发生交换
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }

    public int minSwap1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                //i,i-1都不换的情况
                a = Math.min(a, at);
                //i,i-1都换的情况
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] nums1 =new int[]{1,3,5,4},nums2 =new int[]{1, 2, 3, 7};
        test801 test801=new test801();
        int i = test801.minSwap1(nums1, nums2);
        System.out.println(i);
    }
}
