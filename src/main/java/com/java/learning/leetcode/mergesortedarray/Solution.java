package com.java.learning.leetcode.mergesortedarray;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution {
    private int nums1Total;

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        this.nums1Total = m;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) return;
        //遍历数组2
        for (int i = 0; i < n; i++) {
            int element = nums2[i];
            //然后遍历数组1，找到它应该在哪里
            int j = 0;
            while (m > 0 && nums1[j] < element) {
                //边界判断
                if (nums1[0] >= element) break;
                if (nums1[nums1Total - 1] <= element) {
                    j = nums1Total;
                    break;
                }
                if (nums1[j] < element) j++;
            }
            //j后面所有的元素都后移一位
            if (j < nums1Total)
                removeArray(nums1, j);
            nums1[j] = element;
            nums1Total++;

        }
    }

    private void removeArray(int[] nums1, int j) {
        for (int i = nums1Total - 1; i >= j; i--) {
            nums1[i + 1] = nums1[i];
        }
    }
}
