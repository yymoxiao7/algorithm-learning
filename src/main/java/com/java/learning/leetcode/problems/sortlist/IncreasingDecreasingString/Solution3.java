package com.java.learning.leetcode.problems.sortlist.IncreasingDecreasingString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class Solution3 {
    public String sortString(String s) {
        //26个字母的桶，值表示有几个
        int[] bucket = new int[26];
        char[] input = s.toCharArray();
        //遍历 统计26个字母分别出现多少次
        for (char i : input) {
            bucket[i - 'a']++;
        }
        char[] result = new char[input.length];
        int index = 0;
        while (index < input.length) {
            //从左到右
            for (int j = 0; j < 26; j++) {
                if (bucket[j] != 0) {
                    result[index++] = (char) (j + 'a');
                    bucket[j]--;
                }
            }
            //从右到左
            for (int j = 25; j >= 0; j--) {
                if (bucket[j] != 0) {
                    result[index++] = (char) (j + 'a');
                    bucket[j]--;
                }
            }
        }
        return new String(result);
    }


}
