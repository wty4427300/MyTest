package com.algorithm;

public class test1413 {
    public int minStartValue(int[] nums) {
        int accSum=0,accSumMin=0;
        for (int num:nums){
            accSum+=num;
            accSumMin=Math.min(accSumMin,accSum);
        }
        return -accSumMin+1;
    }

    public static void main(String[] args) {

    }
}
