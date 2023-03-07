package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class test1096 {
    private TreeSet<String> s = new TreeSet<>();
    public List<String> braceExpansionII(String expression) {
        this.dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp){
        int j=exp.indexOf("}");
        //单个元素
        if (j==-1){
            s.add(exp);
            return;
        }
        int i=j;
        while (exp.charAt(i)!='{'){
            i--;
        }
        String a=exp.substring(0,i);
        String c=exp.substring(j+1);
        for (String b:exp.substring(i+1,j).split(",")){
            dfs(a+b+c);
        }
    }
}
