package com.java.learning.algorithm.graph.shortestpath;

public class ShotestPathNode implements Comparable<ShotestPathNode> {
    private int v;
    private int distance;

    public ShotestPathNode(int v, int dis) {
        this.v = v;
        this.distance = dis;
    }

    public int getV() {
        return v;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(ShotestPathNode another) {
        return distance - another.distance;
    }
}
