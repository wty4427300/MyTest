package com.algorithm;

public class test375 {
    static int N=210;
    static int[][] cache=new int[N][N];
    //猜数字
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }

    int dfs(int l,int r){
        if (l>=r){
            return 0;
        }
        if(cache[l][r]!=0){
            return cache[l][r];
        }
        int ans=0x3f3f3f3f;
        for(int x=l;x<=r;x++){
            //当选择的数位x时,至少需要cur才能猜中数字
            int cur=Math.max(dfs(l,x-1),dfs(x+1,r))+x;
            //在所有我们可以决策的数值之间取最优
            ans=Math.min(ans,cur);
        }
        cache[l][r]=ans;
        return ans;
    }
}
