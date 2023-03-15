package com.algorithm;

public class test1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        //存储每个城市的网络秩
        int[] degrees = new int[n];
        //记录城市之间是否直接相连
        boolean[][] connected = new boolean[n][n];
        for(int[] road:roads){
            int city1=road[0],city2=road[1];
            degrees[city1]++;
            degrees[city2]++;
            connected[city1][city2]=true;
            connected[city2][city1]=true;
        }
        int maxRank=0;
        //不同城市对只计算一次比如1,0:0,1
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int rank=degrees[i]+degrees[j];
                if (connected[i][j]){
                    rank--;
                }
                maxRank=Math.max(maxRank,rank);
            }
        }
        return maxRank;
    }
}
