package com.java.learning.leetcode.sumii;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class SolutionSimple {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int total = 0;
        int length = A.length;
        if(length==0){
            return total;
        }
        //最差的情况，直接n^4循环
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
}
