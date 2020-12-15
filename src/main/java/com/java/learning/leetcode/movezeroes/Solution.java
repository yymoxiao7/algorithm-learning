package com.java.learning.leetcode.movezeroes;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        //记录当前第一个为零的下标
        int pointer = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[pointer] = nums[j];
                pointer++;
            }
        }
        for (int k = pointer; k < nums.length; k++) {
            nums[k] = 0;
        }

    }
}
