package com.java.learning.leetcode.isgraphbipartite;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test(){
        int intA[][]={{3,4,6},{3,6},{3,6},{0,1,2,5},{0,7,8},{3},{0,1,2,7},{4,6},{4},{}};
        System.out.println((new Solution()).isBipartite(intA));
    }
}
