package com.java.learning.algorithm.graph.chapter2;

/**
 * 二分图
 */
public class BipartitionDetection {
    private AdjTreeSet adj;
    private int[] colors;
    private boolean[] isVisited;
    //是否是二分图，默认false
    private boolean isBipartition = true;

    public BipartitionDetection(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new boolean[adj.V];
        for (int i = 0; i < adj.V; i++) {
            //先初始化 为-1，-1就表示这个顶点 没被访问过,就两个颜色，0跟-1
            colors[i] = -1;
        }
        for (int i = 0; i < adj.V; i++) {
            if (!isVisited[i]) {
                //一旦i不是二分图，整个 图也肯定不是二分图，直接返回即可
                if (!dfs(i, 0)) {
                    isBipartition = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int index, int color) {
        isVisited[index] = true;
        colors[index] = color;
        //先序
        for (int i : adj.adj(index)) {
            if (!isVisited[i]) {
                if (!dfs(i, 1 - color)) return false;
            } else if (colors[index] == colors[i]) {
                return false;
            }
        }
        return true;
    }

}
