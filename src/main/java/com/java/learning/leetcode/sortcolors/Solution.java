package com.java.learning.leetcode.sortcolors;

import org.springframework.util.Assert;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 三路快排
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        //三路快拍三个下标，[0..zero]是0的区间 [zero+1..one-1]是1的区间 [two..total]是2的区间
        int zero = -1, two = nums.length;
        //第一遍遍历，用于计数，遍历到two的位置即可 ，因为two后面都已经是2了
        for (int i = 0; i < two; ) {

            if (nums[i] == 0) {
                // zero++,交换zero与i的 元素，i++
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                //如果这个元素=1，i++
                i++;
            } else {
                Assert.isTrue(nums[i] == 2, "元素必须是0,1,2其中 之一！");
                //如果等于2 就two--，交换two跟i的位置，i什么都不做
                two--;
                swap(nums, i, two);
            }
        }

    }

    //交换数组中元素i跟元素j的 位置
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
