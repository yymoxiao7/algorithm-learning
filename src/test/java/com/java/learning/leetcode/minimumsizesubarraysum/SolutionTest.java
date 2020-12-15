package com.java.learning.leetcode.minimumsizesubarraysum;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[] nums = {1,4,4};
        System.out.println((new Solution()).minSubArrayLen(4,nums));
    }
    @Test
    public void Solution1() {
        int[] nums = {2,3,1,2,4,3};
        System.out.println((new Solution1()).minSubArrayLen(7,nums));
    }
}
