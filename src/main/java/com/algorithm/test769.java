package com.algorithm;

public class test769 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0;
        //r为块的右边界,l为左边界
        for (int r = 0, l = 0, min = n, max = -1; r < n; r++){
            min=Math.min(min,arr[r]);
            max=Math.max(max,arr[r]);
            if (l==min && r==max){
                ans++;
                l=r+1;
                min=n;
                max=-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{2,3,0,1,4,5};
        test769 test769=new test769();
        int i = test769.maxChunksToSorted(arr);
        System.out.println(i);
    }
}
