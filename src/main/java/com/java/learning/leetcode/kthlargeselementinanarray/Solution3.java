package com.java.learning.leetcode.kthlargeselementinanarray;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 快排
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        Random random = new Random();

        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return quickSort(a, l, r);
    }

    /**
     * 快排
     *
     * @param nums
     * @return 返回本次排序后的基准下标
     */
    private int quickSort(int[] nums, int start, int end) {
        //右边界作为 基准
        int datum = nums[end];
        //共有几个比基准小的数
        int position = start - 1;
        for (int i = start; i < end; i++) {
            //如果这个元素比基准小，就position++再交换position跟i
            if (nums[i] <= datum) {
                position++;
                if (position != i) swap(nums, i, position);
            }
        }
        //交换position与邮编届
        swap(nums, position + 1, end);
        return position + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
