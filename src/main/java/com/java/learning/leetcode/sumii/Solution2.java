package com.java.learning.leetcode.sumii;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class Solution2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int total = 0;
        int length = A.length;
        int lengthSum = length * length;
        if (length == 0) {
            return total;
        }
        //分别对A跟B，C跟D求和，再求和 时间复杂度n^2
        int[] sums1 = new int[lengthSum];
        int[] sums2 = new int[lengthSum];
        arraySum(A, B, sums1, length);
        arraySum(C, D, sums2, length);
        for (int i = 0; i < lengthSum; i++) {
            for (int j = 0; j < lengthSum; j++) {
                if (sums1[i] + sums2[j] == 0)
                    total++;
            }
        }

        return total;
    }

    private void arraySum(int[] a, int[] b, int[] sum, int length) {
        int time = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum[time++] = a[i] + b[j];
            }
        }
    }
}
