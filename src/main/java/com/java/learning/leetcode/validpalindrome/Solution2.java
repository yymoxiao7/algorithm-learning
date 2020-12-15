package com.java.learning.leetcode.validpalindrome;


/**
 * https://leetcode-cn.com/problems/valid-palindrome/submissions/
 * 双指针遍历
 */
public class Solution2 {
    public boolean isPalindrome(String s) {

        char[] strCharArray = s.toCharArray();
        int strLength = strCharArray.length;
        if (strLength == 0) return true;

        //奇数偶数分开处理
        int left = 0, right = strLength - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(strCharArray[left]) && left < right) {
                left++;
            }

            while (!Character.isLetterOrDigit(strCharArray[right]) && left < right) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(strCharArray[left]) != Character.toLowerCase(strCharArray[right]))
                    return false;
                left++;
                right--;
            }
        }

        return true;
    }
}
