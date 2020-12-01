package com.java.learning.study.aha;

import java.util.Stack;

public class StackLearning {

    public boolean isPalindrome(String string) {
        int length = string.length();
        if ((length & 1) != 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        //如果是回文，那么0-中间位置入栈
        for (int i = 0; i < length / 2; i++) {
            stack.push(string.charAt(i));
        }
        //从mid+1-length 出栈判断是否相等
        for (int i = length / 2 + 1; i < length; i++) {
            if (string.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return stack.empty() ? true : false;
    }
}
