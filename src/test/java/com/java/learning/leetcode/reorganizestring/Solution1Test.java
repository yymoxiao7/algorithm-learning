package com.java.learning.leetcode.reorganizestring;

import com.java.learning.leetcode.removelinkedlistelements.ListNode;
import com.java.learning.leetcode.removelinkedlistelements.Solution3;
import org.junit.Test;

public class Solution1Test {
    @Test
    public void test() {
        String str = "kkkkzrkatkwpkkkktrq";
        System.out.println((new Solution1()).reorganizeString(str));
    }

    @Test
    public void tes3() {
        String str ="aabcd";
        System.out.println((new Solution2()).reorganizeString(str));
    }

    @Test
    public void test2() {
        String s = "aabcdd";
        char[] input = s.toCharArray();
        int[] bucket = new int[26];
        int[] orderIndex = {10, 17,19, 0, 15, 16, 22, 25};
        char[] result = new char[input.length];
        //遍历 统计26个字母分别出现多少次
        for (char i : input) {
            bucket[i - 'a']++;
        }
        int index = 0;
        while (index < input.length) {
            for (int j = 0; j < orderIndex.length; j++) {
                //只要j不是最后 一个，并且排序桶里值为1，就重新开始循环
                if (j < orderIndex.length - 1 && bucket[orderIndex[j]] == 1 && bucket[orderIndex[j + 1]] == 1 &&  bucket[orderIndex[0]] > 0) {
                    j=0;
                    break;
                }
                if (bucket[orderIndex[j]] > 0) {
                    //结果的值是排序数组
                    result[index++] = (char) (orderIndex[j] + 'a');
                    bucket[orderIndex[j]]--;
                }
            }
        }
        System.out.println(new String(result));
    }
}
