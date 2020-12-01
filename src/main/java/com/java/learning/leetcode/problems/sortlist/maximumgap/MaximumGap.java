package com.java.learning.leetcode.problems.sortlist.maximumgap;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 */
public class MaximumGap {
    //理解错误，理解成了index相差
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length < 2) return 0;
        //如果长度大于2 开辟个新数组存放排序后的索引
        int[] indexArray = new int[length];
        for (int i = 0; i < length; i++) {
            indexArray[i] = i;
        }
        sortIndex(nums, indexArray, length);
        //对数组进行排序——--这里交换的是index的元素
        int min = 0;
        for (int i = 0; i < length - 1; i++) {
            if (Math.abs(indexArray[i] - indexArray[i + 1]) > min) {
                min = Math.abs(indexArray[i] - indexArray[i + 1]);
            }
        }
        return min;
    }

    //对数组进行排序——--这里交换的是index的元素
    private void sortIndex(int[] nums, int[] indexArray, int length) {
        for (int i = 0; i < length; i++) {
            //里层
            for (int j = 0; j < length - 1; j++) {
                if (nums[indexArray[j]] > nums[indexArray[j + 1]]) {
                    swap(indexArray, j, j + 1);
                }
            }
        }
    }

    //不额外开辟空间，交换i跟j的值
    private void swap(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }
}
