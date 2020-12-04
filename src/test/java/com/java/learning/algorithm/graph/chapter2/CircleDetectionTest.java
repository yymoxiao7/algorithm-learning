package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

public class CircleDetectionTest {
    @Test
    public void getIntArray() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        CircleDetection graphDFS = new CircleDetection(g);
        System.out.println(graphDFS.returnIsCircle());
    }
}
