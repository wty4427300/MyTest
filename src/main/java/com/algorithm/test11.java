package com.algorithm;

public class test11 {
    /**
     * 快慢指针速度太慢过不去
     */
    public int maxArea(int[] height){
        int n=height.length;
        int ans=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int w=j-i;
                int h=Math.min(height[i],height[j]);
                ans=Math.max(w*h,ans);
            }
        }
        return ans;
    }

    /**
     * 左右指针
     */
    public int maxArea1(int[] height){
        int n=height.length;
        int ans=0;
        int i = 0, j = n - 1;
        while (i<j){
            ans=Math.max(ans,(j-i)*Math.min(height[i],height[j]));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return ans;
    }
}
