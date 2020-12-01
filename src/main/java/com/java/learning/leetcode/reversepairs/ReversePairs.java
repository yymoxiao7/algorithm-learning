package com.java.learning.leetcode.reversepairs;

import java.text.DecimalFormat;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class ReversePairs {
    //思路 暴力破解
    public int reversePairs(int[] nums) {
        int total = nums.length;
        double[] halfNums = new double[total];
        int times = 0;
        //nums2赋值
        for (int i = 0; i < total; i++) {
            halfNums[i] = (double) Math.round(nums[i]) / 2;
            ;
        }
        //开始遍历
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (halfNums[i] > nums[j]) times++;
            }
        }
        return times;
    }
}
