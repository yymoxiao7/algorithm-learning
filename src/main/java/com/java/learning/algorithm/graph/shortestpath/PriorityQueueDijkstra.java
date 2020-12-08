package com.java.learning.algorithm.graph.shortestpath;

import com.java.learning.algorithm.graph.weightedgraph.WeightedGraph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 基于优先队列实现 的Dijkstra
 */
public class PriorityQueueDijkstra {
    private WeightedGraph weightedGraph;
    private int source;
    private int[] distance;
    private boolean[] visited;

    public PriorityQueueDijkstra(WeightedGraph weightedGraph, int source) {
        this.weightedGraph = weightedGraph;
        this.source = source;
        distance = new int[weightedGraph.V];
        visited = new boolean[weightedGraph.V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        weightedGraph.validateVertex(source);
        //一开始把源点的路径置为0
        distance[source] = 0;
        Queue<ShotestPathNode> queue = new PriorityQueue<ShotestPathNode>();
        queue.add(new ShotestPathNode(0, 0));
        while (!queue.isEmpty()) {
            //开始获取当前有 记录的边中，权最小的那条
            ShotestPathNode node = queue.poll();
            int currentIndex = node.getV();
            if (visited[currentIndex]) break;

            visited[currentIndex] = true;
            //开始遍历跟这个点相邻的边，并更新
            for (int w : weightedGraph.adj(currentIndex)) {
                if (!visited[w]) {
                    if (distance[currentIndex] + weightedGraph.getWeight(currentIndex, w) < distance[w]) {
                        //currentIndex的路径已经是最小了
                        distance[w] = distance[currentIndex] + weightedGraph.getWeight(currentIndex, w);
                        queue.add(new ShotestPathNode(w, distance[w]));
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
