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
 */
public class Solution {
    //二维数组 的坐标
    private int R, C;
    //图遍历
    private boolean[] isVisited;
    //图
    private HashSet<Integer>[] graph;
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
        //用二维数组构建图
        graph = constructGraph();
        isVisited=new boolean[graph.length];

        int result = 0;
        for (int i = 0; i < graph.length; i++) {
            int x = i / C, y = i % C;
            //如果是陆地，并茄还没遍历过
            if (grid[x][y] == 1 && !isVisited[i]) {
                result = Math.max(result, dfs(i));
            }
        }
        return result;
    }

    /**
     * 从顶点 index开始遍历
     *
     * @param index
     * @return
     */
    private int dfs(int index) {
        isVisited[index] = true;
        int total = 1;
        for (int i : graph[index]) {
            if (!isVisited[i]) {
                total += dfs(i);
            }
        }
        return total;
    }

    private HashSet<Integer>[] constructGraph() {
        HashSet<Integer>[] graph = new HashSet[R * C];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < graph.length; i++) {
            //当前下标转为二维数组的下标 ，看是不是 陆地
            int x = i / C, y = i % C;
            if (grid[x][y] == 1) {
                //查看四周是否有陆地，有的话啧表示有边相连
                for (int d = 0; d < 4; d++) {
                    int nextx = x + dirs[d][0];
                    int nexty = y + dirs[d][1];
                    if (inArea(nextx, nexty) && grid[nextx][nexty] == 1) {
                        int next = nextx * C + nexty;
                        graph[i].add(next);
                        graph[next].add(i);
                    }
                }
            }

        }
        return graph;
    }

    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < C;
    }
}
