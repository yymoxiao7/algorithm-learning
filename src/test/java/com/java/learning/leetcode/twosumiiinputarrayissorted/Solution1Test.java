package com.java.learning.leetcode.twosumiiinputarrayissorted;

import org.junit.Test;

import java.util.List;

public class Solution1Test {
    @Test
    public void test() {
        int[] nums = {-1, 0};
        System.out.println((new Solution()).twoSum(nums, -1));
    }

    @Test
    public void Solution1() {
        int[] nums = {-1, 0};
        System.out.println((new Solution1()).twoSum(nums, -1));
    }
}
