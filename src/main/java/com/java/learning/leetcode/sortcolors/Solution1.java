package com.java.learning.leetcode.sortcolors;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        int white = 0, red = 0, blue = 0;
        //第一遍遍历，用于计数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) red++;
            if (nums[i] == 1) white++;
            if (nums[i] == 2) blue++;
        }
        //第二遍遍历，赋值
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = red; i < (white+red); i++) {
            nums[i] = 1;
        }
        for (int i = (white+red); i < nums.length; i++) {
            nums[i] = 2;
        }

    }
}
