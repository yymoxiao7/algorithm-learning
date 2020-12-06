package com.java.learning.algorithm.graph.hamltonpath;

import com.java.learning.algorithm.graph.chapter2.AdjTreeSet;
import org.junit.Test;

public class HamltonPathTest {
    @Test
    public void testComponent2() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g1.txt");
        HamltonPath cc = new HamltonPath(g,0);
        System.out.println(cc.getPath());
        HamltonPath hamltonPath = new HamltonPath(g,1);
        System.out.println(hamltonPath.getPath());
    }
}
