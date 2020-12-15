package com.java.learning.leetcode.longestsubstringwithoutrepeatingcharacters;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 这里判断已有的字符串是否 重复，搞个ascii码的数字
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] asciiArray = new int[256];
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        char[] strCharArray = s.toCharArray();
        while (end < s.length()) {
            //如果end的ascii码数组的值不为0,就说明前面有重复字符，start就开始++
            while (asciiArray[strCharArray[end]] > 0) {
                asciiArray[strCharArray[start]] = 0;
                start++;
            }
            //记录end的ascii码被访问过
            asciiArray[strCharArray[end]] = 1;
            end++;
            //计算当前长度
            max = Math.max(max, end - start);

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
