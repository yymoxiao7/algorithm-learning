package com.java.learning.leetcode.problems.sortlist.IncreasingDecreasingString;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution1Test {
    @Test
    public void test() {
        String string = "spo";
        Solution1 solution1 = new Solution1();
        String resultString = solution1.sortString(string);
        System.out.println(resultString);
        assertEquals(resultString,"ops");

    }
    @Test
    public void test2() {
        String string = "jkzkydvxewqjfx";
        Solution2 solution1 = new Solution2();
        String resultString = solution1.sortString(string);
        System.out.println(resultString);

    }

    @Test
    public void test3() {
        String string = "jkzkydvxewqjfx";
        Solution3 Solution3 = new Solution3();
        String resultString = Solution3.sortString(string);
        System.out.println(resultString);

    }
}
