package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;

/**
 * 基于 红黑树实现的邻接表的图的深度优先遍历
 * 处理非联通情况
 */
public class AdjTreeSetDFS2 {
    private AdjTreeSet adj;
    private boolean[] isVisited;
    private ArrayList<Integer> preOrder = new ArrayList<>();
    private ArrayList<Integer> postOrder = new ArrayList<>();
    private int cccount = 0;

    AdjTreeSetDFS2(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new boolean[adj.V];
        for (int i = 0; i < adj.V; i++) {
            if (!isVisited[i]) {
                dfs(i);
                cccount++;
            }
        }
    }

    /**
     * 连通数量
     *
     * @return
     */
    public int getCount() {
        return cccount;
    }

    private void dfs(int index) {
        isVisited[index] = true;
        //先序
        preOrder.add(index);
        for (int i : adj.adj(index)) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
        postOrder.add(index);
    }

    public Iterable<Integer> getPreOrder() {
        return preOrder;
    }

    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

}
