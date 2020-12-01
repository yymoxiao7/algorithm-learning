package com.java.learning.leetcode.reorganizestring;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/reorganize-string/
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class Solution2 {
    /**
     * 思路：
     * 首先对这个string进行遍历，把出现的字符/频数放到map中，再对这个map的value也就是字符的频数进行降序排列
     * 如果最大的频数>这个string总长度/2，那么直接返回false
     * 否则，由频数最大的字符->第二大->。。。依次排列组合成新的字符串
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        //26个字母的桶，值表示有几个
        int[] bucket = new int[26];
        //输入
        char[] input = S.toCharArray();
        //遍历 统计26个字母分别出现多少次
        for (char i : input) {
            bucket[i - 'a']++;
        }
        //输出
        char[] result = new char[input.length];
        int max = 0;
        //todo
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > bucket[max]) {
                max = i;
            }
        }
        if (bucket[max] > (int) Math.ceil((double) S.length() / 2)) {
            return "";
        }
        //按照排序 输出
        int index = 0;
        while (bucket[max] > 0) {
            result[index] = (char) (max + 'a');
            index += 2;
            bucket[max]--;
        }
        for (int i = 0; i < 26; i++) {
            while (bucket[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                bucket[i]--;
            }
        }

        return new String(result);
    }
}
