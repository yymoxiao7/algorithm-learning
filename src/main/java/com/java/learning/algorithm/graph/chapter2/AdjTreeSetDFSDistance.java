package com.java.learning.algorithm.graph.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于 红黑树实现的邻接表的图的深度优先遍历
 * 处理非联通情况
 */
public class AdjTreeSetDFSDistance {
    private AdjTreeSet adj;
    private int[] isVisited;
    private ArrayList<Integer> order = new ArrayList<>();
    private int[] pre;
    private int cccount = 0;
    //记录最短路径
    private int[] distance;

    AdjTreeSetDFSDistance(AdjTreeSet adj) {
        this.adj = adj;
        isVisited = new int[adj.V];
        pre = new int[adj.V];
        distance = new int[adj.V];
        for (int i = 0; i < adj.V; i++) {
            isVisited[i] = -1;
            pre[i] = -1;
            distance[i] = -1;
        }
        for (int i = 0; i < adj.V; i++) {
            if (isVisited[i] == -1) {
                dfs(i, cccount);
                cccount++;
            }
        }
    }


    private void dfs(int index, int ccid) {
        isVisited[index] = ccid;
        //实际上这个最短路径就是每个顶点到index的最短路径
        distance[index] = 0;
        Queue<Integer> queue = new LinkedList<>();
        //当前元素进入队列
        queue.add(index);
        pre[index] = index;
        while (!queue.isEmpty()) {
            //出队  放到遍历 数组 中
            Integer poll = queue.poll();
            order.add(poll);
            //开始放下一层 的孩子结点
            for (int i : adj.adj(poll)) {
                if (isVisited[i] == -1) {
                    queue.add(i);
                    isVisited[i] = ccid;
                    pre[i] = poll;
                    distance[i] = 1 + distance[poll];
                }
            }
        }
    }

    public int getDistance(int i) {
        return distance[i];
    }
    public boolean isConnect(int i, int j) {
        adj.validateVertex(i);
        adj.validateVertex(j);
        return isVisited[i] == isVisited[j];
    }
    public Iterable<Integer> path(int source, int t) {
        ArrayList<Integer> list = new ArrayList<>();
        if (!isConnect(source, t)) return null;
        int current = t;
        //从尾开始遍历
        while (current != source) {
            list.add(current);
            current = pre[current];
        }
        list.add(source);
        //数组反转
        Collections.reverse(list);
        return list;
    }

    public Iterable<Integer> getOrder() {
        return order;
    }
}
