package com.algorithm;

public class test1638 {
    public int countSubstrings(String s, String t) {
        int m=s.length(),n=t.length();
        int ans =0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int diff=0;
                for (int k=0;i+k<m&&j+k<n;k++){
                    diff+=s.charAt(i+k)==t.charAt(j+k)?0:1;
                    if (diff>1){
                        //多个字符串不同退出循环
                        break;
                    }else if (diff==1){
                        //一个字符串不同,答案累积
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


}
