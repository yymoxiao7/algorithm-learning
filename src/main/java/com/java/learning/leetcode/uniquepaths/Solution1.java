package com.java.learning.leetcode.uniquepaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 图论求连通分量
 * 先返回个最短路径把
 */
public class Solution1 {
    //路径数
    private ArrayList<Integer> shortestPath;
    //访问记录
    private boolean[][] visited;
    private int[][] dirs = {{0, 1}, {1, 0}};
    private int m, n;

    public ArrayList<Integer> uniquePaths(int m, int n) {
        visited = new boolean[m][n];
        shortestPath = new ArrayList<>();
        this.m = m;
        this.n = n;
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        shortestPath.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / n;
            int y = current % n;
            visited[x][y] = true;
            for (int i = 0; i < 2; i++) {
                int nextx = x + dirs[i][0];
                int nexty = x + dirs[i][1];
                if (inArray(nextx, nexty) && !visited[nextx][nexty]) {
                    int coordinate = nextx * n + nexty;
                    queue.add(coordinate);
                    shortestPath.add(coordinate);
                    if (coordinate == (m * n + n)) break;
                }
            }
        }
        return shortestPath;
    }

    private boolean inArray(int nextx, int nexty) {
        return nextx >= 0 && nextx < m && nexty >= 0 && nexty > n;
    }

}
