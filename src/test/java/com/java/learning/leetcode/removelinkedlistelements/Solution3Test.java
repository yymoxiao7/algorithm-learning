package com.java.learning.leetcode.removelinkedlistelements;

import org.junit.Test;

public class Solution3Test {
    @Test
    public void test(){
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
