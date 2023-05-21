package com.algorithm;

import java.util.Arrays;

public class LCP33 {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        //k为需要蓄水的次数
        for (int k = 1; k <= maxk && k < res; k++) {
            //t需要升级的总次数
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            //总操作数=升级+蓄水
            res = Math.min(res, t + k);
        }
        return res;
    }
}
