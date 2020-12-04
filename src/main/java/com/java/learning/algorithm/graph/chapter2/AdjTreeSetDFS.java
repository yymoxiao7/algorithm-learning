package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;

/**
 * 基于 红黑树实现的邻接表的图的深度优先遍历
 * 这个版本的深度优先遍历，如果图有部分顶点不是 联通的，就会漏电
 */
public class AdjTreeSetDFS {
    private AdjTreeSet adj;
    private boolean[] isVisited;
    private ArrayList<Integer> preOrder = new ArrayList<>();
    private ArrayList<Integer> postOrder = new ArrayList<>();

    AdjTreeSetDFS(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new boolean[adj.V];
        dfs(0);
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
