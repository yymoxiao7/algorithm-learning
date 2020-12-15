package com.java.learning.leetcode.reversestring;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        char[] nums = {'h','e','l','l','o'};
        (new Solution()).reverseString(nums);
        System.out.println(nums);
    }
}
