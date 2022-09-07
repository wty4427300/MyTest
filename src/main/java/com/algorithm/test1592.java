package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1592 {
    public String reorderSpaces(String text) {
        int n = text.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            //统计空格
            if (text.charAt(i) == ' ') {
                ++i;
                ++cnt;
                continue;
            }
            //统计单词
            int j = i;
            while (j < n && text.charAt(j) != ' ') {
                j++;
            }
            list.add(text.substring(i, j));
            i = j;
        }
        int m=list.size(),t=cnt/Math.max(m-1,1);
        //均分后的空格字符串
        StringBuilder k=new StringBuilder();
        while (t-->0){
            k.append(" ");
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m;i++){
            sb.append(list.get(i));
            //字符串结尾不需要空格
            if (i!=m-1){
                sb.append(k);
            }
        }
        while (sb.length()!=n){
            sb.append(" ");
        }
        return sb.toString();
    }
}
