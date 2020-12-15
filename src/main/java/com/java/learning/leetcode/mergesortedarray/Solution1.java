package com.java.learning.leetcode.mergesortedarray;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //从数组1的末尾开始赋值
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (n == 0) {
                break;
            }
            //判断m=0,此时直接用数组2
            if (m == 0) {
                nums1[i] = nums2[i];
                continue;
            }
            if (nums1[m - 1] >= nums2[n - 1]) {
                //如果 nums1的最后 一个元素>num2的，这个值赋值为 nums1
                nums1[i] = nums1[m - 1];
                m--;
            } else if (nums1[m - 1] < nums2[n - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

}
