package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速幂等
 */
public class test2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int powMod(int x, int y, int mod) {
        int res = 1;
        while (y != 0) {
            if ((y & 1) != 0) {
                //奇数
                res = res * x % mod;
            }
            //偶数
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] variables = {{2,6,4,10}};
        test2961 test2961=new test2961();
        List<Integer> goodIndices = test2961.getGoodIndices(variables, 2);
        System.out.println(goodIndices);
    }
}
