package com.algorithm;

public class test1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] cnt = new int[10001];
        int maxCntItem = 0;
        for (int x : barcodes) {
            if (++cnt[x] > cnt[maxCntItem]) {
                maxCntItem = x;
            }
        }
        int idx = 0;
        //先填偶数位
        for (; cnt[maxCntItem] > 0; idx += 2) {
            barcodes[idx] = maxCntItem;
            cnt[maxCntItem]--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0 || i == maxCntItem) {
                continue;
            }
            while (cnt[i] > 0) {
                //偶数位没填完继续填,填完了则从奇数位开始
                if (idx >= barcodes.length) {
                    idx = 1;
                }
                barcodes[idx] = i;
                cnt[i]--;
                idx += 2;
            }
        }
        return barcodes;
    }
}
