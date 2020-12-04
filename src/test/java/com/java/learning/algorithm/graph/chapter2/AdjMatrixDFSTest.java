package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

public class AdjMatrixDFSTest {
    @Test
    public  void getIntArray() {
        AdjMatrix g = new AdjMatrix("src/main/resources/g.txt");
        AdjMatrixDFS graphDFS = new AdjMatrixDFS(g);
        System.out.println(graphDFS.getPreOrder());
        System.out.println(graphDFS.getPostOrder());
    }
}
