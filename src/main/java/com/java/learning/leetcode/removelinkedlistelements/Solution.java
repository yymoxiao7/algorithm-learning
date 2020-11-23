package com.java.learning.leetcode.removelinkedlistelements;

import com.java.learning.hibernate.validation.bean.RedColor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //如果头结点
        if (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev=head;
        //循环移除
        while(prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev=prev.next;
            }
        }


        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}