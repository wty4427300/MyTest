package com.algorithm;

import java.util.Arrays;

public class test473 {

    public boolean makesquare(int[] matchsticks) {
        //计算火柴总长
        int sum = Arrays.stream(matchsticks).sum();
        //总长不等于4的倍数，则无法组成正方形
        if (sum % 4 != 0) {
            return false;
        }
        //排序
        Arrays.sort(matchsticks);
        //倒序(从大到小)
        for (int i=0,j=matchsticks.length-1;i<j;i++,j--){
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[j];
            matchsticks[j]=temp;
        }
        int[] edges=new int[4];
        return this.dfs(0,matchsticks,edges,sum/4);
    }

    public boolean dfs(int index,int[] matchticks,int[] edges,int len){
        if (index==matchticks.length){
            return true;
        }
        for (int i=0;i<edges.length;i++){
            //尝试放入一根火柴
            edges[i]+=matchticks[index];
            //放入下一根
            if(edges[i]<=len && dfs(index+1,matchticks,edges,len)){
                return true;
            }
            //如果放不进去则减去累加
            edges[i]-=matchticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        test473 test473=new test473();
        int[] test={5,5,5,5,4,4,4,4,3,3,3,3};
        test473.makesquare(test);
    }
}
