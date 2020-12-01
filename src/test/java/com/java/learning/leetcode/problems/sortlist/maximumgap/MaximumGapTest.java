package com.java.learning.leetcode.problems.sortlist.maximumgap;

import org.junit.Test;

import java.util.Arrays;

public class MaximumGapTest {
    @Test
    public void test() {
        int[] nums = {3,6,9,1};
        MaximumGap maximumGap=new MaximumGap();
        System.out.println(maximumGap.maximumGap(nums));
    }

    @Test
    public void solution1() {
        int[] nums = {3,6,9,1};
        Solution1 maximumGap=new Solution1();
        System.out.println(maximumGap.maximumGap(nums));
    }
}
