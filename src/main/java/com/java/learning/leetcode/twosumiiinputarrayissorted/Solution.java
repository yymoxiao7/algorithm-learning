package com.java.learning.leetcode.twosumiiinputarrayissorted;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int t = i + 1; t < numbers.length; t++) {
                if (numbers[i] + numbers[t] == target) {
                    result[0] = i + 1;
                    result[1] = t + 1;
                    return result;
                }
            }
        }
        return result;
    }
}
