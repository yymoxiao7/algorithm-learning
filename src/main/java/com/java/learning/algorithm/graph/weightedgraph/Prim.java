package com.java.learning.algorithm.graph.weightedgraph;

import java.util.ArrayList;

public class Prim {
    private WeightedGraph weightedGraph;
    private ArrayList<WeightedEdge> minTree;

    public Prim(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
        minTree = new ArrayList<>();
        CountErgodic countErgodic = new CountErgodic(weightedGraph);
        //如果这个图里有环，那他就没有最小生成树
        if (countErgodic.getCount() > 1) return;
        boolean[] visited = new boolean[weightedGraph.V];
        //从任意一点开始，这里就从第0个元素开始
        visited[0] = true;
        for (int i = 1; i < weightedGraph.V; i++) {
            WeightedEdge min = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
            for (int w = 0; w < weightedGraph.V; w++)
                if (visited[w])
                    for (int next : weightedGraph.adj(w))
                        if (!visited[next] && weightedGraph.getWeight(w, next) < min.getWeight())
                            min = new WeightedEdge(w, next, weightedGraph.getWeight(w, next));
            minTree.add(min);
            visited[min.getV()] = true;
            visited[min.getW()] = true;
            
        }
    }

    public ArrayList<WeightedEdge> getMinTree() {
        return minTree;
    }
}
