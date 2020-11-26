package com.java.learning.leetcode.problems.sortlist.IncreasingDecreasingString;


import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class Solution2 {
    public String sortString(String s) {
        //遍历字符
        int length = s.length();
        List operateList = new ArrayList(Arrays.asList(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
        List<Character> resultArray = new ArrayList<>();

        boolean ascending = true;
        while (length > 0) {
            if (resultArray.size() == 0) {
                Collections.sort(operateList);
            } else if (
                    ascending && ((Character) operateList.get(operateList.size() - 1) <= resultArray.get(resultArray.size() - 1)) ||
                            !ascending && ((Character) operateList.get(operateList.size() - 1) >= resultArray.get(resultArray.size() - 1))
            ) {
                //如果要比较的值恰好是最后一个元素，那么就确保是降序
                Collections.reverse(operateList);
                //状态反转
                ascending = !ascending;
                //然后直接塞第一个元素
                resultArray.add(getFirst(operateList));
                length--;
                continue;
            }

            if (resultArray.size() == 0) {
                resultArray.add(getFirst(operateList));
            } else {
                //找出最后一个值的下一个
                resultArray.add(findNext(operateList, resultArray.get(resultArray.size() - 1), ascending));
            }
            length--;
        }

        return String.valueOf(resultArray);
    }

    private char getFirst(List<Character> charArray) {
        char first = charArray.get(0);
        charArray.remove(0);
        return first;
    }

    //找到数组中除了c的最小值,如果传过来的c已经是最大，就找剩余立面比c小的最大值
    private char findNext(List<Character> chars, char c, boolean ascending) {
        if (ascending && chars.get(0) > c) {
            return getFirst(chars);
        } else if (!ascending && chars.get(0) < c) {
            return getFirst(chars);
        }

        //查找数组中元素不是c的下个元素
        for (int i = 0; i < chars.size() - 1; i++) {
            //如果是升序，就找到比c大的第一个元素
            if ((ascending && chars.get(i) <= c && chars.get(i + 1) > c) || (!ascending && chars.get(i) >= c && chars.get(i + 1) < c)) {
                //这个时候判断c
                char result = chars.get(i + 1);
                chars.remove(i + 1);
                return result;
            }
        }

        return getFirst(chars);
    }


}
