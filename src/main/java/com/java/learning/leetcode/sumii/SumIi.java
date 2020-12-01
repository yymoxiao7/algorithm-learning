package com.java.learning.leetcode.sumii;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class SumIi {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int total = 0;
        int length = A.length;
        int nums;
        //先对四个驻足从小到大排序
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        //记录四个初始下标
        int aPointer = 0, bPointer = 0, cPointer = 0, dPointer = 0;
        //判断四个最小的数之和 如果>0就直接返回
        if (A[aPointer] + B[bPointer] + C[cPointer] + D[dPointer] > 0) {
            return total;
        }

        for (int i = 0; i < length; i++) {
            //当前指针的总数
            nums = A[i] + B[bPointer] + C[cPointer] + D[dPointer];
            if (nums < 0) {
                //先把b的指针往后挪
                while (bPointer < length && A[i] + B[bPointer] + C[cPointer] + D[dPointer] < 0) {
                    bPointer++;
                }
                //b指针循环完要归位0
                bPointer = 0;
                //再挪C的指针
                while (cPointer < length && A[i] + B[bPointer] + C[cPointer] + D[dPointer] < 0) {
                    cPointer++;
                }
                cPointer = 0;
                //先把b的指针往后挪
                while (dPointer < length && A[i] + B[bPointer] + C[cPointer] + D[dPointer] < 0) {
                    dPointer++;
                }
            } else if (nums == 0) {
                //如果恰巧等于0 就++
                total++;
            } else {
                //如果大于 就终止
                break;
            }
        }
        return total;
    }
}
