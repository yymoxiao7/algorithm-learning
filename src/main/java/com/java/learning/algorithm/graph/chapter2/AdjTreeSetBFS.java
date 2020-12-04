package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于 红黑树实现的邻接表的图的广度优先遍历--即树的层级遍历
 * 处理非联通情况
 */
public class AdjTreeSetBFS {
    private AdjTreeSet adj;
    private boolean[] isVisited;
    private ArrayList<Integer> order = new ArrayList<>();

    AdjTreeSetBFS(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new boolean[adj.V];
        for (int i = 0; i < adj.V; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }


    private void dfs(int index) {
        isVisited[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        //当前元素进入队列
        queue.add(index);
        while (!queue.isEmpty()) {
            //出队  放到遍历 数组 中
            Integer poll = queue.poll();
            order.add(poll);
            //开始放下一层 的孩子结点
            for (int i : adj.adj(poll)) {
                if (!isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }

    }

    public Iterable<Integer> getOrder() {
        return order;
    }
}
