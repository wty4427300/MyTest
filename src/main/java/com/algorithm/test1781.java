package com.algorithm;

public class test1781 {
    public int beautySum(String s) {
        int res= 0;
        for (int i=0;i<s.length();i++){
            //26个字母打表
            int[] cnt=new int[26];
            int max=0;
            //每个字母开始统计字符串
            for (int j=i;j<s.length();j++){
                cnt[s.charAt(j)-'a']++;
                //获取最多出现次数
                max=Math.max(max,cnt[s.charAt(j)-'a']);
                int min=s.length();
                for (int k=0;k<26;k++){
                    if (cnt[k]>0){
                        min=Math.min(min,cnt[k]);
                    }
                }
                res+=max-min;
            }
        }
        return res;
    }
}
