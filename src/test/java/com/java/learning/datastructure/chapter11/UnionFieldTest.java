package com.java.learning.datastructure.chapter11;

import org.junit.Test;

import java.util.Random;

public class UnionFieldTest {
    private static double testUF(UnionField uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnection(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    @Test
    public void  test(){
        int size = 100000;
        int m = 100000;

        UnionField1 uf1 = new UnionField1(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionField2 uf2 = new UnionField2(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        UnionField3 uf3 = new UnionField3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionField4 uf4 = new UnionField4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");
    }
}
