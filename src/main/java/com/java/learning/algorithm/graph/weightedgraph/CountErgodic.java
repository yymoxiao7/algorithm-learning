package com.java.learning.algorithm.graph.weightedgraph;

/**
 * 联通分量遍历
 */
public class CountErgodic {
    private WeightedGraph weightedGraph;
    private int count;
    private boolean[] visited;

    public CountErgodic(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
        visited = new boolean[weightedGraph.V];
        count = 0;
        for (int i = 0; i < weightedGraph.V; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int i) {
        visited[i] = true;

        for (int next : weightedGraph.adj(i)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public int getCount() {
        return count;
    }
}
