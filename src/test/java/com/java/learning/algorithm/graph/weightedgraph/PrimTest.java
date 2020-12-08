package com.java.learning.algorithm.graph.weightedgraph;

import java.util.ArrayList;

public class PrimTest {

    private WeightedGraph G;
    private ArrayList<WeightedEdge> mst;

    public PrimTest(WeightedGraph G) {

        this.G = G;
        mst = new ArrayList<>();

        CC cc = new CC(G);
        if (cc.count() > 1) return;

        boolean[] visited = new boolean[G.V()];
        visited[0] = true;
        for (int i = 1; i < G.V(); i++) {

            WeightedEdge minEdge = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
            for (int v = 0; v < G.V(); v++)
                if (visited[v])
                    for (int w : G.adj(v))
                        if (!visited[w] && G.getWeight(v, w) < minEdge.getWeight())
                            minEdge = new WeightedEdge(v, w, G.getWeight(v, w));
            mst.add(minEdge);
            visited[minEdge.getV()] = true;
            visited[minEdge.getW()] = true;
        }
    }

    public ArrayList<WeightedEdge> result() {
        return mst;
    }


}
