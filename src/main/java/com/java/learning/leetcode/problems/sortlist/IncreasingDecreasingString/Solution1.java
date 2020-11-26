package com.java.learning.leetcode.problems.sortlist.IncreasingDecreasingString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class Solution1 {
    public String sortString(String s) {
        //遍历字符
        HashMap<Character, Integer> timesMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!timesMap.containsKey(c)) {
                timesMap.put(c, 1);
            } else {
                timesMap.put(c, timesMap.get(c) + 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        //按照times大小排序
        timesMap = timesMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new));
        Optional<Map.Entry<Character, Integer>> first = timesMap.entrySet().stream().findFirst();
        //最大值就代表循环多少次
        Integer maxTimes = first.get().getValue();
        int loop = 1;
        while (maxTimes > 0) {
            //每次排序都要取出的不重复char
            List<Character> chars = new ArrayList<>();
            Iterator<Map.Entry<Character, Integer>> iter = timesMap.entrySet().iterator();

            while (iter.hasNext()) {
                Character key = iter.next().getKey();
                int time = timesMap.get(key);
                if (time > 1) {
                    timesMap.put(key, time - 1);
                } else {
                    iter.remove();//添加此行代码
                    timesMap.remove(key);
                }
                chars.add(key);
            }

            //如果循环次数是奇数，就是升序，偶数就是降序
            if ((loop & 1) == 1) {
                //奇数 是升序
                Collections.sort(chars);
            } else {
                //偶数 降序
                Collections.sort(chars, Collections.reverseOrder());
            }
            chars.forEach(stringBuilder::append);
            maxTimes--;
            loop++;
        }
        return stringBuilder.toString();
    }


}
