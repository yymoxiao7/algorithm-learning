package com.java.learning.algorithm.graph.hamltonpath;

import com.java.learning.algorithm.graph.chapter2.AdjTreeSet;
import org.junit.Test;


public class HamltonLoopTest {
    @Test
    public  void testComponent() {
        Graph g = new Graph("src/main/resources/g1.txt");
        HamiltonLoop1 cc = new HamiltonLoop1(g);
        System.out.println(cc.result());
    }

    @Test
    public  void testComponent2() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g1.txt");
        HamltonLoop cc = new HamltonLoop(g);
        System.out.println(cc.getPath());
    }
}
