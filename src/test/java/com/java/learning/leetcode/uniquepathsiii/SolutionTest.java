package com.java.learning.leetcode.uniquepathsiii;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        Solution solutionSimple = new Solution();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.uniquePathsIII(a));
        ;

    }

    @Test
    public void test1() {
        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        Solution1 solutionSimple = new Solution1();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.uniquePathsIII(a));
        ;

    }

    @Test
    public void test2() {
        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        SolutionStatesCompression solutionSimple = new SolutionStatesCompression();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.uniquePathsIII(a));
        ;

    }
}
