package com.java.learning.leetcode.dota2senate;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/dota2-senate/
 */
public class Solution {
    private boolean[] status;
    private int pointer;
    private int nextPointer;
    private char[] senateArray;

    public String predictPartyVictory(String senate) {
        status = new boolean[senate.length()];
        senateArray = senate.toCharArray();
        //记录字符串中 有 多少个R多少个D,0是R，1是D
        int Radiant = 0, Dire = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senateArray[i] == 'R') {
                Radiant++;
            } else if (senateArray[i] == 'D') {
                Dire++;
            }
        }
        pointer = 0;
        getUpdatePointer((senateArray[pointer] == 'R') ? 'D' : 'R');
        //只要R桶或者D桶都不为空就继续 循环
        while (pointer >= 0 && nextPointer >= 0 && Radiant > 0 && Dire > 0) {
            if (senateArray[pointer] == 'R') {
                Dire--;
            } else if (senateArray[pointer] == 'D') {
                Radiant--;
            }
            //更新下个指标
            status[nextPointer] = true;
            getNextPointer();
        }

        if (Radiant == 0) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }


    //找到当前pointer的下一个没有被访问过的指针，并记录下面将要更新的指针
    private void getNextPointer() {
        boolean pointerFlag = false;
        char thisChar = 'R';
        //第一次循环，先找出pointer下一个没被标记过是指针
        for (int i = 1; i < status.length; i++) {
            if (!status[(pointer + i) % status.length]) {
                pointerFlag = true;
                pointer = (pointer + i) % status.length;
                thisChar = (senateArray[pointer] == 'R') ? 'D' : 'R';
                break;
            }
        }
        getUpdatePointer(thisChar);
        if (!pointerFlag) {
            pointer = -1;
        }
    }

    private void getUpdatePointer(char thisChar) {
        boolean nextPointerFlag = false;

        //找pointer下第一个没被标记过并且值=thisChar的指针
        for (int i = 1; i < status.length; i++) {
            if (!status[(pointer + i) % status.length] && senateArray[(pointer + i) % status.length] == thisChar) {
                nextPointerFlag = true;
                nextPointer = (pointer + i) % status.length;
                break;
            }
        }

        if (!nextPointerFlag) {
            nextPointer = -1;
        }
    }
}
