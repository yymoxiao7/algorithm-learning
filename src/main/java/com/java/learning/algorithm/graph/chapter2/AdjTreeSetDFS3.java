package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;

/**
 * 基于 红黑树实现的邻接表的图的深度优先遍历
 * 处理非联通情况
 */
public class AdjTreeSetDFS3 {
    private AdjTreeSet adj;
    private int[] isVisited;
    private ArrayList<Integer> preOrder = new ArrayList<>();
    private ArrayList<Integer> postOrder = new ArrayList<>();
    private int cccount = 0;

    AdjTreeSetDFS3(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new int[adj.V];
        for (int i = 0; i < adj.V; i++) {
            isVisited[i] = -1;
        }
        for (int i = 0; i < adj.V; i++) {
            if (isVisited[i] == -1) {
                dfs(i, cccount);
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
        for (int e : isVisited)
            System.out.print(e + " ");
        System.out.println();
        return cccount;
    }

    private void dfs(int index, int ccid) {
        isVisited[index] = ccid;
        //先序
        preOrder.add(index);
        for (int i : adj.adj(index)) {
            if (isVisited[i] == -1) {
                dfs(i, ccid);
            }
        }
        postOrder.add(index);
    }

    /**
     * 判断两个顶点是否是连通的
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isConnect(int i, int j) {
        adj.validateVertex(i);
        adj.validateVertex(j);
        return isVisited[i] == isVisited[j];
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] components = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++) {
            components[i] = new ArrayList<>();
        }
        for (int j = 0; j < adj.V; j++) {
            components[isVisited[j]].add(j);
        }
        return components;
    }

    public Iterable<Integer> getPreOrder() {
        return preOrder;
    }

    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

}
