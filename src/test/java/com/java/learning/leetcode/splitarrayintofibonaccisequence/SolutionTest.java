package com.java.learning.leetcode.splitarrayintofibonaccisequence;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        String str="214748364721474836422147483641";
        Solution solution = new Solution();
        List<Integer> integers = solution.splitIntoFibonacci(str);
        System.out.println(integers);
    }
}
