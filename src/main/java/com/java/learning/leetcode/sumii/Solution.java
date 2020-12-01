package com.java.learning.leetcode.sumii;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int total = 0;
        int length = A.length;
        if (length == 0) {
            return total;
        }
        //分别对A跟B，C跟D求和，再求和 时间复杂度n^2
        Map<Integer, Integer> sum = new HashMap<>();
        //A+B放map
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (sum.containsKey(A[i] + B[j])) {
                    sum.put(A[i] + B[j], sum.get(A[i] + B[j]) + 1);
                } else {
                    sum.put(A[i] + B[j], 1);
                }
            }
        }
        //C+D
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (sum.containsKey(-(C[i] + D[j]))) {
                    total += sum.get(-(C[i] + D[j]));
                }
            }
        }
        return total;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int total=0;
        //分别对A跟B，C跟D求和，再求和 时间复杂度n^2
        Map<Integer, Integer> sum = new HashMap<>();
        //A+B放map
        int current;
        for (int a:A) {
            for (int b:B) {
               /* if (sum.containsKey(a+b)) {
                    sum.put(a+b, sum.get(a+b) + 1);
                } else {
                    sum.put(a+b, 1);
                }*/
                current=a+b;
                sum.put(current, sum.getOrDefault(current,0)+1);
            }
        }
        //C+D
        for (int c:C) {
            for (int d:D) {
                current=-(c+d);
                if (sum.containsKey(current)) {
                    total += sum.get(current);
                }
            }
        }
        return total;
    }

}
