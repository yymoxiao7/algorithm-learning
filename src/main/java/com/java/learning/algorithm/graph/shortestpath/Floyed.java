package com.java.learning.algorithm.graph.shortestpath;

import com.java.learning.algorithm.graph.weightedgraph.WeightedGraph;

import java.util.Arrays;

/**
 * Floyd-Warshall算法是解决任意两点间的最短路径的一种算法，可以正确处理有向图或负权的最短路径问题
 */
public class Floyed {
    private WeightedGraph weightedGraph;
    private int[][] distance;
    //是否存在负权环
    private boolean hasNegCycle;

    public Floyed(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
        distance = new int[weightedGraph.V][weightedGraph.V];
        for(int v = 0; v < weightedGraph.V(); v ++)
            Arrays.fill(distance[v], Integer.MAX_VALUE);
        //一开始把源点的路径置为0
        for (int i = 0; i < weightedGraph.V; i++) {
            distance[i][i] = 0;
            for (int j : weightedGraph.adj(i)) {
                distance[i][j] = weightedGraph.getWeight(i, j);
            }
        }
        for (int t = 0; t < weightedGraph.V; t++) {
            for (int v = 0; v < weightedGraph.V; v++) {
                for (int w = 0; w < weightedGraph.V; w++) {
                    if (distance[t][v] != Integer.MAX_VALUE && distance[t][w] != Integer.MAX_VALUE &&
                            distance[t][v] + distance[t][w] < distance[v][w]
                    )
                        distance[v][w] = distance[t][v] + distance[t][w];
                }
            }
        }
        for (int k = 0; k < weightedGraph.V; k++) {
            if (distance[k][k] < 0) {
                hasNegCycle = true;
                break;
            }
        }
    }

    public boolean hasNegativeCycle() {
        return hasNegCycle;
    }

}
