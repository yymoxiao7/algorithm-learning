package com.java.learning.leetcode.dota2senate;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        System.out.println((new Solution()).predictPartyVictory("RD"));
    }

    @Test
    public void test1(){
        System.out.println((new Solution1()).predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
