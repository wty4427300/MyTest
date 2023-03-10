package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test1590 {
    public int minSubarray(int[] nums, int p) {
        int k=0;
        for(int x:nums){
            k=(k+x)%p;
        }
        if (k==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int n=nums.length;
        int ans=n;
        int cur=0;
        for (int i=0;i<n;i++){
            cur=(cur+nums[i])%p;
            int target=(cur-k+p)%p;
            if (map.containsKey(target)){
                ans=Math.min(ans,i-map.get(target));
            }
            map.put(cur,i);
        }
        return ans==n?-1:ans;
    }
}
