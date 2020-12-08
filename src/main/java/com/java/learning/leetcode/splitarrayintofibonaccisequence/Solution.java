package com.java.learning.leetcode.splitarrayintofibonaccisequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {

        //string转int数组
        char[] charArray = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        //int最大长度
        int maxLength = charArray.length / 2;

        for (int i = maxLength; i > 0; i--) {
            //如果没找到对应的斐波那契list就给stack重新赋值
            stack.clear();
            getStack(charArray, stack);
            List<Integer> result = new ArrayList<>();
            boolean fibonacci = getFibonacci(stack, i, result);
            if (fibonacci) {
                Collections.reverse(result);
                return result;
            }
        }
        return Collections.emptyList();
    }

    private boolean getFibonacci(Stack<Character> stack, int maxLength, List<Integer> list) {
        //终止条件判断
        if (maxLength == 0) {
            return false;
        }
        if (stack.empty()) {
            return true;
        }
        //最后的数字一定是最长的
        int last = getNumberFromStack(stack, maxLength);
        if (stack.empty()) {
            return false;
        }
        for (int i = maxLength; i > 0; i--) {
            for (int j = maxLength; j > 0; j--) {
                boolean end = false;

                int first = getNumberFromStack(stack, i);
                int second = getNumberFromStack(stack, j);

                if (first == -1 || second == -1) {
                    if (first == -1 && second != -1) pushNumberIntoStack(stack, second);
                    if (first != -1 && second == -1) pushNumberIntoStack(stack, first);

                    break;
                }

                if (stack.size() == 0 && last == (first + second)) {
                    end = true;
                }
                //返回前，first跟second要入栈
                pushNumberIntoStack(stack, second);
                pushNumberIntoStack(stack, first);
                if (last == (first + second)) {
                    list.add(last);
                    if (!end) {
                        return getFibonacci(stack, Math.max(i, j), list);
                    } else {
                        list.add(first);
                        list.add(second);
                        return true;
                    }
                }
            }
        }


        return false;
    }

    //数字入栈 从高位开始入栈
    private void pushNumberIntoStack(Stack<Character> stack, int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int length = chars.length;
        int time = 0;
        while (length > 0) {
            stack.add(chars[time]);
            length--;
            time++;
        }
    }

    //数字入栈 从高位开始入栈
    private void pushNumberIntoStack(Stack<Character> stack, char[] chars) {
        int length = chars.length;
        int time = 0;
        while (length > 0) {
            stack.add(chars[time]);
            length--;
            time++;
        }
    }

    //从栈中取出长度为n的数
    private int getNumberFromStack(Stack<Character> stack, int length) {
        if (stack.empty() || length > stack.size())
            return -1;
        length = Math.min(length, stack.size());
        char[] chars = new char[length];

        while (length > 0) {
            chars[length - 1] = stack.pop();
            length--;
        }
        if (chars.length > 1 && chars[0] == '0') {
            pushNumberIntoStack(stack, chars);
            return -1;
        }
        //因为上面算法当length=1时多加了个1
        return Integer.parseInt(new String(chars));
    }

    private void getStack(char[] charArray, Stack<Character> stack) {
        for (int i = 0; i < charArray.length; i++) {
            //入栈
            stack.add(charArray[i]);
        }
    }

}
