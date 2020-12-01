package com.java.learning.leetcode.findfirstandlast;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test(){
        int[] nums = {1,1,1,2,4,4,4,5,5,5,5,6,7,8,8,9,9,9,9,9,9,10};
        System.out.println(Arrays.toString((new Solution()).searchRange(nums,9)));
    }
}
