package com.java.learning.leetcode.dota2senate;


/**
 * https://leetcode-cn.com/problems/dota2-senate/
 */
public class Solution1 {

    private char[] senateArray;
    private boolean[] status;
    private int pointer;
    private int nextPointer;

    public String predictPartyVictory(String senate) {
        senateArray = senate.toCharArray();
        status = new boolean[senate.length()];
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
        getUpdatePointer(senateArray[0] == 'R' ? 'D' : 'R');
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

    private void getNextPointer() {
        for (int i = 1; i < status.length; i++) {
            if (!status[(pointer + i) % status.length]) {
                pointer = (pointer + i) % status.length;
                char thisChar = (senateArray[pointer] == 'R') ? 'D' : 'R';
                getUpdatePointer(thisChar);
                return;
            }
        }
        pointer = -1;
    }

    private void getUpdatePointer(char thisChar) {

        //找pointer下第一个没被标记过并且值=thisChar的指针
        for (int i = 1; i < status.length; i++) {
            if (!status[(pointer + i) % status.length] && senateArray[(pointer + i) % status.length] == thisChar) {
                nextPointer = (pointer + i) % status.length;
                return;
            }
        }

        nextPointer = -1;

    }

}
