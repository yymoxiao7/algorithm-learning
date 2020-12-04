package com.java.learning.leetcode.isgraphbipartite;

/**
 * 入参已经是图的邻接表二维数组 了
 * 二分图
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class Solution {
    private int[] colors;
    private boolean[] visited;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        //顶点总数
        int v = graph.length;
        colors = new int[v];
        visited = new boolean[v];


        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int index, int color) {
        visited[index] = true;
        colors[index] = color;
        for (int i : graph[index]) {
            if (!visited[i]) {
                if (!dfs(i, 1 - color)) return false;
            } else if (colors[i] == colors[index]) {
                return false;
            }
        }
        return true;
    }
}
