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
public class Solution1 {
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
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        //按照times大小排序
        charFrequencyMap = charFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new));
        //最大值就代表循环多少次
        Optional<Map.Entry<Character, Integer>> first = charFrequencyMap.entrySet().stream().findFirst();
        Integer maxTimes = first.get().getValue();
        if (maxTimes > (int) Math.ceil((double) S.length() / 2)) {
            return "";
        }
        int i = S.length() ;
        while (i > 0) {
            //每次排序都要取出的不重复char
            Iterator<Map.Entry<Character, Integer>> iter = charFrequencyMap.entrySet().iterator();

            while (iter.hasNext()) {
                Character key = iter.next().getKey();
                int time = charFrequencyMap.get(key);
                i--;
                if (time > 1) {
                    charFrequencyMap.put(key, time - 1);
                } else {
                    iter.remove();//添加此行代码
                    charFrequencyMap.remove(key);
                    stringBuilder.append(key);
                    break;
                }
                stringBuilder.append(key);
            }
        }
        return stringBuilder.toString();
    }
}
