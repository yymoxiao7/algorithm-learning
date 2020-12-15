package com.java.learning.leetcode.findallanagramsinastring;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        String str = "cbaebabacd";
        String target = "abc";
        System.out.println((new Solution()).findAnagrams(str, target));
    }

    @Test
    public void test1() {
        String str = "cbaebabacd";
        String target = "abc";
        System.out.println((new Solution1()).findAnagrams(str, target));
    }

}
