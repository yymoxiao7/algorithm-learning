package com.java.learning.leetcode.findallanagramsinastring;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] dictionaries = new int[26];
        for (char c : p.toCharArray()) {
            dictionaries[c - 'a']++;
        }
        //只要end还没超过s的边界
        for (int start = 0; start <= s.length() - p.length(); start++) {
            if (isHeterotopic(s, start, start + p.length(), dictionaries)) result.add(start);
        }
        return result;
    }

    //判断字符串s中，以start下标开始的后面几位是否是p的异位词
    private boolean isHeterotopic(String s, int start, int end, int[] dictionaries) {

        String startWord = s.substring(start, end);
        int[] thisChar = new int[26];
        for (char c : startWord.toCharArray()) {
            thisChar[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (thisChar[i] != dictionaries[i]) return false;
        }
        return true;
    }
}
