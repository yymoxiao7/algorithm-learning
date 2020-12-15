package com.java.learning.algorithm.graph.directedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 */
public class TopoSort {
    private WeightedGraph graph;
    private ArrayList<Integer> path;
    private boolean hasCycle;

    public TopoSort(WeightedGraph graph) {
        if (!graph.isDirected())
            throw new IllegalArgumentException("TopoSort only works in directed graph.");

        this.graph = graph;
        path = new ArrayList<>();
        int[] indegree = new int[graph.V];
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < graph.V; v++) {
            indegree[v] = graph.indegree(v);
            if (graph.indegree(v) == 0)
                queue.add(v);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            path.add(current);
            for (int next : graph.adj(current)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }

        if (path.size() != graph.V) {
            hasCycle = true;
            path.clear();
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public ArrayList<Integer> result() {
        return path;
    }

}
