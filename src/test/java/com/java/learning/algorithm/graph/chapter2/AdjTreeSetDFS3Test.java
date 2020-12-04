package com.java.learning.algorithm.graph.chapter2;

import org.junit.Test;

import java.util.ArrayList;

public class AdjTreeSetDFS3Test {
    @Test
    public  void getIntArray() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetDFS3 graphDFS = new AdjTreeSetDFS3(g);
        System.out.println(graphDFS.getCount());
    }

    @Test
    public  void testComponent() {
        AdjTreeSet g = new AdjTreeSet("src/main/resources/g.txt");
        AdjTreeSetDFS3 cc = new AdjTreeSetDFS3(g);
        System.out.println(cc.getCount());

        System.out.println(cc.isConnect(0, 6));
        System.out.println(cc.isConnect(5, 6));

        ArrayList<Integer>[] comp = cc.components();
        for(int ccid = 0; ccid < comp.length; ccid ++){
            System.out.print(ccid + " : ");
            for(int w: comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
