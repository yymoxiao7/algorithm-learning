package com.java.learning.algorithm.graph.weightedgraph;

import com.java.learning.datastructure.chapter11.UnionField4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * kruskal算法得到最小生成树
 */
public class Kruskal {
    private WeightedGraph weightedGraph;
    private ArrayList<WeightedEdge> minTree;

    public Kruskal(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
        minTree = new ArrayList<>();
        CountErgodic countErgodic = new CountErgodic(weightedGraph);
        //如果这个图里有环，那他就没有最小生成树
        if (countErgodic.getCount() > 1) return;
        //取出这个图 里所有 的边，并排序
        ArrayList<WeightedEdge> weightedEdgeArrayList = new ArrayList<>();
        for (int i = 0; i < weightedGraph.V; i++) {
            for (int j : weightedGraph.adj(i)) {
                WeightedEdge weightedEdge = WeightedEdge.builder().v(i).w(j).weight(weightedGraph.getWeight(i, j)).build();
                weightedEdgeArrayList.add(weightedEdge);
            }
        }
        //按照权重对边进行排序
        Collections.sort(weightedEdgeArrayList);
        UF unionField4 = new UF(weightedGraph.V);
        for (WeightedEdge edge : weightedEdgeArrayList) {
            int v = edge.getV();
            int w = edge.getW();
            //这样取的肯定是最小的，然后 如果这两个顶点不联通
            if (!unionField4.isConnected(v, w)) {
                minTree.add(edge);
                unionField4.unionElements(v, w);
            }
        }
    }

    public ArrayList<WeightedEdge> getMinTree() {
        return minTree;
    }
}
