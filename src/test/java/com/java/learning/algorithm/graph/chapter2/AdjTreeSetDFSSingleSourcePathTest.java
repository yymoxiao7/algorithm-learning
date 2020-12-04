package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

public class AdjTreeSetDFSSingleSourcePathTest {
    @Test
    public void test() {

        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetDFSSingleSourcePath sspath = new AdjTreeSetDFSSingleSourcePath(g, 0);
        System.out.println("0 -> 6 : " + sspath.path(6));
        System.out.println("0 -> 5 : " + sspath.path(5));
    }

}
