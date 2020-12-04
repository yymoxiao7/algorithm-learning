package com.java.learning.leetcode.maxareaofisland;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。
 * 解题思路：
 * 转化为图的连通顶点总数
 * 首先，一个二维数组的1就 代表是一个顶点
 * 两个连着的1就 代表 一条边
 * 优化：思路一样，去掉构建图的过程
 */
public class Solution2 {
    //二维数组 的坐标
    private int R, C;
    //图遍历
    private boolean[][] isVisited;

    //这个 二维数组
    private int[][] grid;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        //二维数组合法性判断
        if (grid == null) return 0;
        if (grid.length == 0) return 0;
        R = grid.length;
        if (grid[0].length == 0) return 0;
        C = grid[0].length;
        //二维数组合法
        this.grid = grid;
        isVisited = new boolean[R][C];

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //如果是陆地，并茄还没遍历过
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    result = Math.max(result, dfs(i, j));
                }
            }
        }
        return result;
    }

    /**
     * 从顶点 index开始遍历
     *
     * @return
     */
    private int dfs(int x, int y) {
        isVisited[x][y] = true;
        int total = 1;
        for (int d = 0; d < 4; d++) {
            int nextx = x + dirs[d][0];
            int nexty = y + dirs[d][1];
            if (inArea(nextx, nexty) && grid[nextx][nexty] == 1 && !isVisited[nextx][nexty]) {
                total += dfs(nextx, nexty);
            }
        }
        return total;
    }
    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < C;
    }
}
