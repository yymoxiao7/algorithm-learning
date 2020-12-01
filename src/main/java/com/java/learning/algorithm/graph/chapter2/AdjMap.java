package com.java.learning.algorithm.graph.chapter2;

public class AdjMap extends BaseGraph implements GraphInterface {

    @Override
    public boolean hasEdge(int v, int w) {
        return false;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }

    @Override
    public int degree(int v) {
        return 0;
    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }
}
