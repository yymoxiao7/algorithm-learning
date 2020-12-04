package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;

/**
 * 邻接矩阵的深度优先便利
 */
public class AdjMatrixDFS {
    private AdjMatrix adjMatrix;
    private boolean[] isVisited;
    private ArrayList<Integer> preOrder = new ArrayList<>();
    private ArrayList<Integer> postOrder = new ArrayList<>();

    public AdjMatrixDFS(AdjMatrix adj) {
        this.adjMatrix = adj;
        isVisited = new boolean[adj.V];
        for (int i = 0; i < adj.V; i++) {
            if (!isVisited[i]) dfs(i);
        }
    }

    public void dfs(int index) {
        isVisited[index] = true;
        preOrder.add(index);
        for (int i : adjMatrix.adj(index)) {
            if (!isVisited[i]) dfs(i);
        }
        postOrder.add(index);
    }
    public Iterable<Integer> getPreOrder(){
        return preOrder;
    }
    public Iterable<Integer> getPostOrder(){
        return postOrder;
    }
}
