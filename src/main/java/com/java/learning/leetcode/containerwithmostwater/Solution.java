package com.java.learning.leetcode.containerwithmostwater;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) right--;
            else left++;
        }
        return max;

    }

}
