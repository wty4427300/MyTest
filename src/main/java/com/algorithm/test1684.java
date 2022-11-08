package com.algorithm;

public class test1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans=words.length;
        for(int i=0;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                if(!allowed.contains(String.valueOf(c))){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
