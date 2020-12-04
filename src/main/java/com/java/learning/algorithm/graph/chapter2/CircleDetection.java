package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;

/**
 * 基于 红黑树实现的邻接表的图的环检测
 * 处理非联通情况
 */
public class CircleDetection {
    private AdjTreeSet adj;
    private boolean[] isVisited;
    private boolean isCircle = false;

    CircleDetection(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new boolean[adj.V];
        for (int i = 0; i < adj.V; i++) {
            if (!isVisited[i]) {
                dfs(i, i);
            }
        }
    }

    private void dfs(int index, int parent) {
        isVisited[index] = true;
        //先序
        for (int i : adj.adj(index)) {
            if (!isVisited[i]) {
                dfs(i, index);
            } else if (i != parent) {
                isCircle = true;
            }
        }
    }

    public boolean returnIsCircle() {
        return isCircle;
    }

}
