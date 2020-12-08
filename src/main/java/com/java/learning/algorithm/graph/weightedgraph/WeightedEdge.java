package com.java.learning.algorithm.graph.weightedgraph;

import lombok.Builder;
import lombok.Data;

/**
 * 权重的边
 */
@Data
@Builder
public class WeightedEdge implements Comparable<WeightedEdge> {
    private int v;
    private int w;
    private int weight;

    @Override
    public int compareTo(WeightedEdge another) {
        return weight - another.weight;
    }
}
