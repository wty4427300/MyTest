package com.algorithm;

public class test464 {

    int n, t;
    //1<<20,1左移20=1048576
    //因为n最大为20，所以用二进制表示整数是否被使用的情况，最大数为1<<20
    //这样就开辟了足够的dp空间
    int[] f = new int[1 << 20];

    int dfs(int state, int tot) {
        if (f[state] != 0) return f[state];
        for (int i = 0; i < n; i++) {
            //当前数字在当前回合是否使用，使用了就跳出当前回合
            if (((state >> i) & 1) == 1) continue;
            //当前回合成功直接返回
            if (tot + i + 1 >= t) return f[state] = 1;
            //判断下一个回合是否会失败，如果下个回合会失败则本回合成功
            //渲染下一个回合的位置并计算
            if (dfs(state | (1 << i), tot + i + 1) == -1) return f[state] = 1;
        }
        return f[state] = -1;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        n = maxChoosableInteger;
        t = desiredTotal;
        //计算1---n的整数和，如果累加的结果还是小于desiredTotal则谁都赢不了
        int x = n * (n + 1) / 2;
        if (x < t) {
            return false;
        }
        //如果desiredTotal=0，则谁先手谁赢
        if (t == 0) {
            return true;
        }
        return this.dfs(0, 0) == 1;
    }

    public static void main(String[] args) {
        test464 test464 = new test464();
        test464.canIWin(10, 11);
    }
}
