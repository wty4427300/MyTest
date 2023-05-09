package com.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CHEN
 * @description
 * @date 2023/5/10
 **/
public class test1015 {
    public int smallestRepunitDivByK(int k) {
        int resid=1%k,len=1;
        Set<Integer> set=new HashSet<>();
        set.add(resid);
        while (resid!=0){
            resid=(resid*10+1)%k;
            len++;
            if (set.contains(resid)){
                return -1;
            }
            set.add(resid);
        }
        return len;
    }
}
