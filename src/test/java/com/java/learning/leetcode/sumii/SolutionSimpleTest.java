package com.java.learning.leetcode.sumii;

import com.java.learning.study.aha.Deciphering;
import org.junit.Test;

public class SolutionSimpleTest {
    @Test
    public void test() {
        int[] a = {1, 1, -1, -1};
        int[] b = {-1, -1, 1, 1};
        int[] c = {1, -1, 0, -1};
        int[] d = {1, 1, -1, 1};
        SolutionSimple solutionSimple = new SolutionSimple();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.fourSumCount(a, b, c, d));;

    }
}
