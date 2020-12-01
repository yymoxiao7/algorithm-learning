package com.java.learning.leetcode.reversepairs;

import com.java.learning.leetcode.removelinkedlistelements.ListNode;
import com.java.learning.leetcode.removelinkedlistelements.Solution3;
import org.junit.Test;

public class ReversePairsSolutionTest {
    @Test
    public void test() {
        int[] nums = {2,4,3,5,1};
        System.out.println((new ReversePairs()).reversePairs(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2,4,3,5,1};
        System.out.println((new Solution()).reversePairs(nums));
    }
}
