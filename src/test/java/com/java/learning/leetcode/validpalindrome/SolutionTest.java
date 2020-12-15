package com.java.learning.leetcode.validpalindrome;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        String str = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        Solution solutionSimple = new Solution();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.isPalindrome(str));
    }

    @Test
    public void Solution1() {
        String str = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        Solution1 solutionSimple = new Solution1();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.isPalindrome(str));
    }

    @Test
    public void Solution2() {
        String str = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        Solution2 solutionSimple = new Solution2();
        //deciphering.getNumber(nums)
        System.out.println(solutionSimple.isPalindrome(str));
    }
}
