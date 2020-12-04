package com.java.learning.leetcode.shortestpathinbinarymatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class Solution {
    //二维数组 的坐标
    private int R;
    private int C;
    //图遍历
    private boolean[][] isVisited;
    //最短路径
    private int[][] dis;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        //二维数组合法性判断
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;
        isVisited = new boolean[R][C];
        dis = new int[R][C];
        if (grid[0][0] == 1) return -1;
        if (R == 1 && C == 1) return 1;
        //BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty() && grid[R - 1][C - 1] == 0) {
            int[] current = queue.poll();
            //换算成二维 数组下标
            int x = current[0], y = current[1];
            int currentLength = dis[x][y];

            for (int d = 0; d < 8; d++) {
                int nextx = x + dirs[d][0];
                int nexty = y + dirs[d][1];
                if (inArea(nextx, nexty) && grid[nextx][nexty] == 0 && !isVisited[nextx][nexty]) {
                    queue.add(new int[]{nextx, nexty});
                    dis[nextx][nexty] = 1 + currentLength;
                }
            }

        }

        return dis[R - 1][C - 1];
    }

    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < R;
    }
}
