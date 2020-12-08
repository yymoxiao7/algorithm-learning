package com.java.learning.algorithm.graph.shortestpath;

import com.java.learning.algorithm.graph.weightedgraph.WeightedGraph;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 通过Dijkstra算法获取到某个点的最短路径
 * 思想：
 * 构造函数传入某个源点
 * 遍历，依次获取当前遍历过的边的权重的 最小值，从而确定到 一个点的最短路径
 * 依次遍历与这个点 相连的 其余 点
 * 每次确定 一个 点
 * 不允许负权边
 */
public class Dijkstra {
    private WeightedGraph weightedGraph;
    private int source;
    private int[] distance;
    private boolean[] visited;

    public Dijkstra(WeightedGraph weightedGraph, int source) {
        this.weightedGraph = weightedGraph;
        this.source = source;
        distance = new int[weightedGraph.V];
        visited = new boolean[weightedGraph.V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        weightedGraph.validateVertex(source);
        //一开始把源点的路径置为0
        distance[source] = 0;
        while (true) {
            //开始获取当前有 记录的边中，权最小的那条
            int currentIndex = -1, currentDis = Integer.MAX_VALUE;
            for (int i = 0; i < weightedGraph.V; i++) {
                if (!visited[i] && distance[i] < currentDis) {
                    currentDis = distance[i];
                    currentIndex = i;
                }
            }
            if (currentIndex == -1) break;
            visited[currentIndex] = true;
            //开始遍历跟这个点相邻的边，并更新
            for (int w : weightedGraph.adj(currentIndex)) {
                if (!visited[w]) {
                    if (distance[currentIndex] + weightedGraph.getWeight(currentIndex, w) < distance[w]) {
                        //currentIndex的路径已经是最小了
                        distance[w] = distance[currentIndex] + weightedGraph.getWeight(currentIndex, w);
                    }
                }

            }
        }
    }

    public boolean isConnectedTo(int v) {

        weightedGraph.validateVertex(v);
        return visited[v];
    }

    public int distTo(int v) {

        weightedGraph.validateVertex(v);
        return distance[v];
    }

    public int[] getDistance() {
        return distance;
    }
}
