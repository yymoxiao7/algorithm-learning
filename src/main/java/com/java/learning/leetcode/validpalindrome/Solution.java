package com.java.learning.leetcode.validpalindrome;

import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/submissions/
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toLowerCase();
        char[] strCharArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char value : strCharArray) stack.add(value);

        for (char c : strCharArray) if (stack.pop() != c) return false;

        return stack.empty();
    }
}
