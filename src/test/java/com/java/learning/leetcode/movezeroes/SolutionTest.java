package com.java.learning.leetcode.movezeroes;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int intA[] = {0,1,3,0,12};
        (new Solution()).moveZeroes(intA);
        System.out.println(intA);
    }
}
