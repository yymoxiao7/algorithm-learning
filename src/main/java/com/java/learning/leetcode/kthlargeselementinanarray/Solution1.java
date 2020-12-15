package com.java.learning.leetcode.kthlargeselementinanarray;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 快排
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        int datumIndex = quickSort(nums, 0, nums.length - 1);
        //因为是按照升序排列，k是查找第k个最大的所以
        k = nums.length - k;

        while (datumIndex != k) {
            if (k > datumIndex)//应该在右边继续找
                datumIndex = quickSort(nums, datumIndex + 1, nums.length - 1);
            else datumIndex = quickSort(nums, 0, datumIndex - 1);

        }
        return nums[datumIndex];
    }

    /**
     * 快排
     *
     * @param nums
     * @return 返回本次排序后的基准下标
     */
    private int quickSort(int[] nums, int start, int end) {
        int datum = nums[start];
        int i = start, j = end;
        while (i < j) {
            //从游标找第一个比基准小的 元素
            while (nums[j] >= datum && i < j) {
                j--;
            }
            //从左边找 比基准大的第一个元素
            while (nums[i] <= datum && i < j) {
                i++;
            }

            //找到后   如果i<j 就交换i,j
            if (i < j) {
                swap(nums, i, j);
            }
        }
        //当i=j  交换i,0 并返回i
        swap(nums, start, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
