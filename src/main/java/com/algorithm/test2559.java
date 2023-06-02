package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n= words.length;
        int[] s=new int[n+1];
        for (int i=0;i<n;i++){
            //判断首尾是否是
            char a=words[i].charAt(0),b=words[i].charAt(words[i].length()-1);
            s[i+1]=s[i]+(vowels.contains(a) && vowels.contains(b)?1:0);
        }
        int m=queries.length;
        int[] ans=new int[m];
        for (int i=0;i<m;i++){
            int l=queries[i][0],r=queries[i][1];
            ans[i]=s[r+1]-s[l];
        }
        return ans;
    }
}
