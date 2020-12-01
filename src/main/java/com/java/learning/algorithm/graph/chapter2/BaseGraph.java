package com.java.learning.algorithm.graph.chapter2;

/**
 * 图基类
 */
public abstract class BaseGraph {
    /**
     * 顶点总数
     */
    public int V;
    /**
     * 边总数
     */
    public int E;

    public void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("v 不合法！");
        }
    }
}
