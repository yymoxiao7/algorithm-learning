package com.java.learning.algorithm.graph.chapter2;

/**
 * 图接口
 */
public interface GraphInterface {
    /**
     * 这两个顶点是否相连
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     * 查找顶点的所有临边
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    /**
     * 某个顶点的度
     * @param v
     * @return
     */
    int degree(int v);

    /**
     * 返回这个图的顶点个数
     * @return
     */
    int V();

    /**
     * 返回这个图的边总数
     * @return
     */
    int E();
}
