package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ms_17_05 {
    public String[] findLongestSubarray(String[] array) {
        int n=array.length;
        int[] s=new int[n+1];
        //计算前缀和
        for (int i=0;i<n;i++){
            //s[i+1]=s[i]+array[i]
            //array[i].charAt(0)>>6&1 判断一个字符串是数字还是字母
            s[i+1]=s[i]+(array[i].charAt(0)>>6&1)*2-1;
        }
        int begin = 0, end = 0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<=n;i++){
            int j=map.getOrDefault(s[i],-1);
            if (j<0){
                map.put(s[i],i);
            }else if(i-j>end-begin){
                begin=j;
                end=i;
            }
        }
        String[] sub=new String[end-begin];
        System.arraycopy(array,begin,sub,0,sub.length);
        return sub;
    }
}
