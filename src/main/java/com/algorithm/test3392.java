package com.algorithm;

public class test3392 {
    public int countSubarrays(int[] nums) {
        int length = nums.length;
        int ans=0;
        for(int i=0;i<length-2;i++){
            if((nums[i]+nums[i+2])*2==nums[i+1]){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test3392 solution = new test3392();
        int[] testArray = {-1,-4,-1,4};
        int result = solution.countSubarrays(testArray);
        System.out.println("The number of subarrays is: " + result);
    }
}
