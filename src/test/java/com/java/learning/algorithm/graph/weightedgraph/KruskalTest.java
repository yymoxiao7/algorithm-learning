package com.java.learning.algorithm.graph.weightedgraph;

import org.junit.Test;

public class KruskalTest {
    @Test
    public void bubbleSort() {

        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        Kruskal kruskal = new Kruskal(g);
        System.out.println(kruskal.getMinTree());
        System.out.println(kruskal.getMinTree().size());
    }

    @Test
    public void prim() {

        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        Prim prim = new Prim(g);
        System.out.println(prim.getMinTree());
        System.out.println(prim.getMinTree().size());
    }


    @Test
    public void prim2() {

        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        PrimTest prim = new PrimTest(g);
        System.out.println(prim.result());
        System.out.println(prim.result().size());
    }

    @Test
    public void prim3() {

        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        PriorityQueuePrim prim = new PriorityQueuePrim(g);
        System.out.println(prim.getMinTree());
        System.out.println(prim.getMinTree().size());
    }
}
