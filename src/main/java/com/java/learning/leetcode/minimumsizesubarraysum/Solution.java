package com.java.learning.leetcode.minimumsizesubarraysum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int total = nums[i];
            int count = 1;

            int j = i + 1;

            while (total < s && j < nums.length && count < min) {
                total += nums[j];
                count++;
                j++;
            }
            if (total >= s) {
                min = Math.min(count, min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private boolean isNotAbs(int[] nums, int j) {
        return Math.abs(nums[j] - nums[j - 1]) != 1;
    }
}
