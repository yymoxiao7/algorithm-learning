package com.java.learning.study.aha;

import java.util.LinkedList;

/**
 * 啊哈算法 qq解密
 * 一串数字，比如631758924
 * 先出第一个数字，然后把第二个数组放在队尾，然后出第三个，以此类推 直到最后一个
 * 最后输出：
 * 615947283
 * 用队列
 */
public class Deciphering {
    public int[] getNumber(int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        //队列赋值
        for (int i = 0; i < nums.length; i++) {
            linkedList.add(nums[i]);
        }
        int[] result = new int[nums.length];
        int i = 0;
        while (linkedList.size() > 0) {
            //第一个元素出队
            result[i] = linkedList.getFirst();
            i++;
            linkedList.removeFirst();
            if (linkedList.size() > 0)
                //第二个元素去队尾
                linkedList.addLast(linkedList.removeFirst());
        }
        return result;
    }
}
