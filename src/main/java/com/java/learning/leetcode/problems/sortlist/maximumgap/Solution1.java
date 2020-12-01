package com.java.learning.leetcode.problems.sortlist.maximumgap;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 */
public class Solution1 {
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length < 2) return 0;
        //如果长度大于2 开辟个新数组存放排序后的索引
        Arrays.sort(nums);
        //对数组进行排序——--这里交换的是index的元素
        int min = 0;
        for (int i = 0; i < length - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) > min) {
                min = Math.abs(nums[i] - nums[i + 1]);
            }
        }
        return min;
    }

}
