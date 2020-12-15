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
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] > target)
                right--;
            else if (numbers[left] + numbers[right] < target)
                left++;
            else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        return result;
    }
}
