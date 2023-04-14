package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            ans.add(this.check(q, pattern));
        }
        return ans;
    }

    private Boolean check(String s,String t){
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        for (;j<n;i++,j++){
            while (i<m && s.charAt(i)!=t.charAt(j) && Character.isLowerCase(s.charAt(i))){
                //如果不相同,且是小写字母,可以随意补充
                i++;
            }
            if(i==m || s.charAt(i)!=t.charAt(j)){
                return false;
            }
        }
        //判断后续字符串是否都是小写
        while (i < m && Character.isLowerCase(s.charAt(i))) {
            ++i;
        }
        return i == m;
    }
}
