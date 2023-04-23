package com.algorithm;

public class test1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        //f[i] 表示前 i 本书摆放的最小高度
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int w = books[i - 1][0], h = books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    //无法放在同一层
                    break;
                }
                //可以放在同一层
                h = Math.max(h, books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[][] books = new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        test1105 test1105 = new test1105();
        int i = test1105.minHeightShelves(books, shelfWidth);
        System.out.println(i);
    }
}
