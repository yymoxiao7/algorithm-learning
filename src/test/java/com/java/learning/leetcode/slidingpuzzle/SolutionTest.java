package com.java.learning.leetcode.slidingpuzzle;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[][] nums = {{1,2,3},{4,0,5}};
        System.out.println((new Solution()).slidingPuzzle(nums));
    }
}
