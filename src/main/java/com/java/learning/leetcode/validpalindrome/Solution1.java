package com.java.learning.leetcode.validpalindrome;


/**
 * https://leetcode-cn.com/problems/valid-palindrome/submissions/
 * 双指针遍历
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        char[] strCharArray = s.toCharArray();
        int strLength = strCharArray.length;
        if (strLength==0) return true;

        //奇数偶数分开处理
        int left = 0, right = strLength - 1;
        //如果长度是偶数
        if (strLength % 2 == 0) {
            int mid = strLength / 2;
            while (left <= mid) {
                if (strCharArray[left] != strCharArray[right]) return false;
                left++;
                right--;
            }
        }else{
            //奇数
            int mid = strLength / 2;
            while (left < mid) {
                if (strCharArray[left] != strCharArray[right]) return false;
                left++;
                right--;
            }
        }

        return true;
    }
}
