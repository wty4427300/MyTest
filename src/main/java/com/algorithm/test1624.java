package com.algorithm;

import java.util.Arrays;

public class test1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr=new int[26];
        Arrays.fill(arr,310);
        int n=s.length(),ans=-1;
        for(int i=0;i<n;i++){
            //记录字母的下标
            int x=s.charAt(i)-'a';
            arr[x]=Math.min(arr[x],i);
            ans=Math.max(ans,i-arr[x]-1);
        }
        return ans;
    }
}
