package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

import java.util.ArrayList;

public class AdjTreeSetBFSTest {
    @Test
    public void getIntArray() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetBFS graphDFS = new AdjTreeSetBFS(g);
        System.out.println(graphDFS.getOrder());
    }

    @Test
    public void testBFSPath() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetBFSSingleSourcePath sspath = new AdjTreeSetBFSSingleSourcePath(g);
        System.out.println("0 -> 6 : " + sspath.path(0, 6));
        System.out.println("0 -> 5 : " + sspath.path(0, 5));
    }

    @Test
    public void testBFSDistance() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetDFSDistance sspath = new AdjTreeSetDFSDistance(g);
        System.out.println("0 -> 6 : " + sspath.path(0, 6));
        System.out.println("0 -> 5 : " + sspath.path(0, 5));
        System.out.println("0 -> 6 : " + sspath.getDistance(6));
    }
}
