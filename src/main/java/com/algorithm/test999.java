package com.algorithm;

public class test999 {
    public int numRookCaptures(char[][] board) {
        //st,ed存储车的位置
        int cnt = 0, st = 0, ed = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            for (int step = 1; ; step++) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                //到达边界或者遇到象退出
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                //遇到卒结果++
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
