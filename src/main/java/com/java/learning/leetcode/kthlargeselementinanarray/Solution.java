package com.java.learning.leetcode.kthlargeselementinanarray;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        int total = 0;
        while (total < k) {
            int max = Integer.MIN_VALUE;
            int frequency = 0;
            for (int num : nums) {
                if (!maxMap.containsKey(num)) {
                    if (num > max) {
                        max = num;
                        frequency = 1;
                    } else if (num == max) frequency++;
                }
            }
            maxMap.put(max, frequency);
            total += frequency;
            if (total >= k) return max;
        }
        return -1;
    }
}
