package com.java.learning.leetcode.splitarrayintofibonaccisequence;

import org.junit.Test;

import java.util.List;

public class Solution1Test {
    @Test
    public void test() {
        String str="1101111";
        Solution1 solution = new Solution1();
        List<Integer> integers = solution.splitIntoFibonacci(str);
        System.out.println(integers);
    }
}
