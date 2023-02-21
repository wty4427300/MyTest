package com.algorithm;

import java.util.Arrays;

public class test1326 {
    public int minTaps(int n, int[] ranges) {
        // 定义一个区间数组
        int[][] region = new int[n + 1][2];
        // 将原来的水龙头位置信息转化为洒水区间信息
        for (int i = 0; i <= n; i++) {
            int[] temp = new int[2];
            temp[0] = Math.max(0, i - ranges[i]);
            temp[1] = Math.min(n, i + ranges[i]);
            region[i] = temp;
        }
        //以左端点为标准进行升序
        Arrays.sort(region, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //初始化答案，当前可用最右位置
        int res = 0, right = 0;
        //初始化当前区间
        int cur = 0;
        //遍历所有区间
        while (cur < n + 1) {
            //当前区间无法覆盖到最右的有效工作范围，那么就会存在覆盖不到的间隙
            if (region[cur][0] > right) break;
            //遍历可以覆盖到已经可用的最右点的下一个可用的最右边点
            int rt = right;
            while (cur < n + 1 && region[cur][0] <= right) {
                rt = Math.max(rt, region[cur][1]);
                cur++;
            }
            res++;
            right = rt;
            //已经遍历到整个范围
            if (right == n) break;
        }
        return right == n ? res : -1;
    }
}
