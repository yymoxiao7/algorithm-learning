package com.java.learning.leetcode.minimumwindowsubstring;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class Solution {
    public String minWindow(String s, String t) {
        //minStart表示最小窗口 的开始指针 ，start和end表示开始跟终止的指针，total表示窗口内还需要多少个目标t里的 字符
        int minStart = 0, start = 0, end = 0, min = Integer.MAX_VALUE, total = t.length();
        int[] window = new int[57];
        int[] target = new int[57];
        for (char c : t.toCharArray()) {
            target[c - 'A']++;
        }
        while (end < s.length()) {
            int endCharIndex = s.charAt(end) - 'A';
            //判断最右边在不在target中
            if (target[endCharIndex] > 0) {
                //窗口内的统计 ++
                window[endCharIndex]++;
                if (window[endCharIndex] <= target[endCharIndex]) {
                    //如果在窗口内的end的字符数小于或等于 目标的字符数，total才--
                    total--;
                }
            }
            //如果total=0，就代表了此时target的几个字符都在窗口内
            while (total == 0) {
                if (end - start + 1 < min) {
                    minStart = start;
                    min = end - start + 1;
                }
                int startCharIndex = s.charAt(start) - 'A';
                //要根据条件，开始缩小窗口 范围
                if (target[startCharIndex] > 0) {
                    window[startCharIndex]--;
                    if (window[startCharIndex] < target[startCharIndex]) {
                        total++;
                    }
                }
                start++;
            }
            end++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }
}
