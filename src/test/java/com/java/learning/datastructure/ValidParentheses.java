package com.java.learning.datastructure;

import org.junit.Test;

/**
 * 有效的括号--leetCode题
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {


    public boolean judgeValidParentheses(String str) {
        boolean result = false;
        ArrayStack<Character> parentheses = new ArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (ifPush(item)) {
                parentheses.push(item);
            }
            if (ifPop(item,parentheses)) {
                parentheses.pop();
            }
        }

        if(parentheses.isEmpty()) return true;
        return result;
    }

    public boolean ifPush(char c) {
        return c=='{'|| c=='('|| c=='[';
    }

    public boolean ifPop(char item, ArrayStack<Character> parentheses) {
        return (item=='}' && parentheses.peek()=='{') ||
                (item==']' && parentheses.peek()=='[') ||
                (item==')' && parentheses.peek()=='(');
    }

    @Test
    public void test(){
        String string="(]";
        System.out.println(judgeValidParentheses(string));
    }

}
