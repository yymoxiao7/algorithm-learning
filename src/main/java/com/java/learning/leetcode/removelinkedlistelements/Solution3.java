package com.java.learning.leetcode.removelinkedlistelements;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode next = removeElements(head.next, val);
        if (head.val == val) {
            return next;
        } else {
            head.next = next;
            return head;
        }
    }
}

