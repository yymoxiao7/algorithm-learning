package com.java.learning.mergesortedarray;


import com.java.learning.leetcode.mergesortedarray.Solution;
import com.java.learning.leetcode.mergesortedarray.Solution1;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        Solution solutionSimple = new Solution();
        solutionSimple.merge(nums1, 0, nums2, 1);
        System.out.println(nums1);

    }
    @Test
    public void test1() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution1 solutionSimple = new Solution1();
        solutionSimple.merge(nums1, 3, nums2, 3);
        System.out.println(nums1);

    }
}
