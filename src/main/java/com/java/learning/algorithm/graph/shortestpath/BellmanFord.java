package com.java.learning.algorithm.graph.shortestpath;

import com.java.learning.algorithm.graph.weightedgraph.WeightedGraph;

import java.util.Arrays;

/**
 * 对图进行V-1次松弛操作，得到所有可能的最短路径。
 */
public class BellmanFord {
    private WeightedGraph weightedGraph;
    private int source;
    private int[] distance;
    private boolean[] visited;
    //是否存在负权环
    private boolean hasNegCycle;

    public BellmanFord(WeightedGraph weightedGraph, int source) {
        this.weightedGraph = weightedGraph;
        this.source = source;
        distance = new int[weightedGraph.V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        weightedGraph.validateVertex(source);
        //一开始把源点的路径置为0
        distance[source] = 0;
        for (int pass = 1; pass < weightedGraph.V; pass++) {
            for (int v = 0; v < weightedGraph.V; v++) {
                for (int w : weightedGraph.adj(v)) {
                    if (distance[v] != Integer.MAX_VALUE && distance[v] + weightedGraph.getWeight(v, w) < distance[w])
                        distance[w] = distance[v] + weightedGraph.getWeight(v, w);
                }
            }
        }
        //最后再遍历一轮，看看有没有负全边
        for (int v = 0; v < weightedGraph.V; v++) {
            for (int next : weightedGraph.adj(v)) {
                if (distance[next] > distance[v] + weightedGraph.getWeight(v, next)) {
                    hasNegCycle = true;
                    break;
                }
            }
        }
    }

    public boolean hasNegativeCycle() {
        return hasNegCycle;
    }

}
