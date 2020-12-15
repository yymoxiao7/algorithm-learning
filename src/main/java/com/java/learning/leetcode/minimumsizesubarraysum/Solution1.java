package com.java.learning.leetcode.minimumsizesubarraysum;

public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;

        int sum = 0, start = 0, end = 0;
        while (end < nums.length) {
            //只要当前综合小于s 就继续入队
            sum += nums[end];
            end++;
            //当总和大于s的时候，记录当前的长度，并左边--
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
