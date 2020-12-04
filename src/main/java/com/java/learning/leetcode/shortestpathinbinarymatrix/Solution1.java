package com.java.learning.leetcode.shortestpathinbinarymatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class Solution1 {
    //二维数组 的坐标
    private int R;
    private int C;
    //图遍历

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        //二维数组合法性判断
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;
        if (grid[0][0] == 1 || grid[R - 1][C - 1]==1) return -1;
        if (R == 1 && C == 1) return 1;
        //BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty() && grid[R - 1][C - 1] == 0) {
            int[] current = queue.poll();
            //换算成二维 数组下标
            int x = current[0], y = current[1];
            int currentLength = grid[x][y];

            for (int d = 0; d < 8; d++) {
                int nextx = x + dirs[d][0];
                int nexty = y + dirs[d][1];
                if (inArea(nextx, nexty) && grid[nextx][nexty] == 0) {
                    queue.add(new int[]{nextx, nexty});
                    grid[nextx][nexty] = 1 + currentLength;
                }
            }

        }

        return grid[R - 1][C - 1]==0?-1:grid[R - 1][C - 1];
    }



    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < R;
    }
}
