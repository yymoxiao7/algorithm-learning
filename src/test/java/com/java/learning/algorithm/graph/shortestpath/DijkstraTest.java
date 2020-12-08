package com.java.learning.algorithm.graph.shortestpath;

import com.java.learning.algorithm.graph.two_buckets_of_water.Solution;
import com.java.learning.algorithm.graph.weightedgraph.PrimTest;
import com.java.learning.algorithm.graph.weightedgraph.WeightedGraph;
import org.junit.Test;

public class DijkstraTest {
    @Test
    public void bubbleSort() {
        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        Dijkstra prim = new Dijkstra(g, 0);
        int[] distance = prim.getDistance();
        System.out.println(distance);
    }

    @Test
    public void priorityQueueDijkstra() {
        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        PriorityQueueDijkstra prim = new PriorityQueueDijkstra(g, 0);
        int[] distance = prim.getDistance();
        System.out.println(distance);
    }

    @Test
    public void bellmanFord() {
        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        BellmanFord prim = new BellmanFord(g, 0);
        System.out.println(prim.hasNegativeCycle());
    }

    @Test
    public void Floyed() {
        WeightedGraph g = new WeightedGraph("src/main/resources/gWeightedGraph.txt");
        Floyed prim = new Floyed(g);
        System.out.println(prim.hasNegativeCycle());
    }
}
