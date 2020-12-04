package com.java.learning.leetcode.shortestpathinbinarymatrix;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[][] nums = {{0,1},{1,0}};
        System.out.println((new Solution()).shortestPathBinaryMatrix(nums));
    }
}
