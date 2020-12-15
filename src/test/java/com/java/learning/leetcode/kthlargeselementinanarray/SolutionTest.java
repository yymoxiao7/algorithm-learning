package com.java.learning.leetcode.kthlargeselementinanarray;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        int intA[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println((new Solution()).findKthLargest(intA, 4));
    }

    @Test
    public void quickSort() {
        int intA[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println((new Solution1()).findKthLargest(intA, 1));
    }
    @Test
    public void quickSort2() {
        int intA[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println((new Solution2()).findKthLargest(intA, 2));
    }
    @Test
    public void quickSort3() {
        int intA[] = {3,2,1,5,6,4};
        System.out.println((new Solution3()).findKthLargest(intA, 2));
    }
}
