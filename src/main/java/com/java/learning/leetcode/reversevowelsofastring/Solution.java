package com.java.learning.leetcode.reversevowelsofastring;


public class Solution {
    public String reverseVowels(String s) {
        char[] strCharArray = s.toCharArray();
        int left = 0, right = strCharArray.length - 1;
        while (left < right) {
            while (left < right && isNotVowel(strCharArray[left])) {
                left++;
            }
            while (left < right && isNotVowel(strCharArray[right])) {
                right--;
            }
            if (left < right) {
                swap(strCharArray, left, right);
                left++;
                right--;
            }
        }

        return new String(strCharArray);
    }

    private void swap(char[] strCharArray, int left, int right) {
        char temp = strCharArray[left];
        strCharArray[left] = strCharArray[right];
        strCharArray[right] = temp;
    }

    private boolean isNotVowel(char c) {
        c = Character.toLowerCase(c);
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }
}
