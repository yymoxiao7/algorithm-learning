package com.java.learning.leetcode.containerwithmostwater;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int capacity = Math.min(height[i], height[j]) * (j - i);
                if (capacity > max)
                    max = capacity;
            }
        }


        return max;

    }

}
