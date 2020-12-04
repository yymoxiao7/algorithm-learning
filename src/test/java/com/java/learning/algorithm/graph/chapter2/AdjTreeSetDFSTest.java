package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

public class AdjTreeSetDFSTest {
    @Test
    public  void getIntArray() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetDFS graphDFS = new AdjTreeSetDFS(g);
        System.out.println(graphDFS.getPreOrder());
        System.out.println(graphDFS.getPostOrder());
    }
}
