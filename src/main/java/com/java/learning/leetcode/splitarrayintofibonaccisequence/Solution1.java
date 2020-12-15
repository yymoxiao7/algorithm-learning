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
public class Solution1 {
    private String input;
    private List<Integer> result;
    //记录当前遍历的指针
    private int pointer;

    public List<Integer> splitIntoFibonacci(String S) {

        //string转int数组
        this.input = S;
        int strLength = input.length();
        //int最大长度
        int maxLength = Math.min(strLength / 2, 10);

        for (int i = maxLength; i > 0; i--) {
            pointer = strLength - 1;
            result = new ArrayList<>();
            boolean fibonacci = getFibonacci(i);
            if (fibonacci) {
                Collections.reverse(result);
                return result;
            }
        }
        return Collections.emptyList();
    }

    private boolean getFibonacci(int maxLength) {
        //终止条件判断,如果只剩下了最后两位，说明其余的全部遍历过
        if (pointer <= 1) {
            return true;
        }
        int last = getNumber(maxLength);
        //按照当前的长度，逐渐去找
        for (int i = maxLength; i > 0; i--) {
            for (int j = maxLength; j > 0; j--) {
                boolean end = false;

                int first = getNumber(i);
                int second = getNumber(j);

                if (first == -1 || second == -1 ) {
                    if (first == -1 && second != -1) pointerRecall(j);
                    if (first != -1 && second == -1) pointerRecall(i);
                    continue;
                }

                if (pointer == -1 && last == (first + second)) {
                    end = true;
                }
                //返回前，first跟second要入栈
                pointerRecall(j);
                pointerRecall(i);
                if (last == (first + second)) {
                    result.add(last);
                    if (!end) {
                        return getFibonacci(Math.max(i, j));
                    } else {
                        result.add(first);
                        result.add(second);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getNumber(int length) {
        int startInext = pointer - length + 1;
        if (startInext < 0) {
            return -1;
        }
        //如果开头是0
        if (length > 1 && input.charAt(startInext) == '0') {
            return -1;
        }
        try {
            int result = Integer.parseInt(input.substring(startInext, pointer + 1));
            //指针移动
            pointer = pointer - length;
            return result;
        } catch (IllegalArgumentException e) {
            return -1;
        }

    }

    private void pointerRecall(int i) {
        pointer = pointer + (i);
    }

}
