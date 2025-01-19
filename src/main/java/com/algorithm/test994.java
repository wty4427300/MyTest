package com.algorithm;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 思路基本上是转化成图的广度优先遍历
 */
public class test994 {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        //矩阵长宽
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        //遍历矩阵，找到腐烂橘子
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    //每个腐烂橘子是一个原点
                    queue.add(code);
                    //腐烂橘子初始化深度是0
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            //求出腐烂橘子的坐标
            int r = code / C, c = code % C;
            //最多腐烂周围四个橘子
            //当 k = 0 时，dr[0] = -1 和 dc[0] = 0，表示向上移动，即坐标变为 (x-1, y)。
            //当 k = 1 时，dr[1] = 0 和 dc[1] = -1，表示向左移动，即坐标变为 (x, y-1)。
            //当 k = 2 时，dr[2] = 1 和 dc[2] = 0，表示向下移动，即坐标变为 (x+1, y)。
            //当 k = 3 时，dr[3] = 0 和 dc[3] = 1，表示向右移动，即坐标变为 (x, y+1)。
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    //新鲜橘子变腐烂橘子
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        //有新鲜橘子未腐烂
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
