package com.java.learning.leetcode.emonadechange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) return false;
        //记录存钱 0代表5元 1代表10元，2代表20
        int[] bucket = new int[3];
        //队列初始化
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                bucket[0]++;
                continue;
            } else if (bills[i] == 10) {
                bucket[1]++;
            } else if (bills[i] == 20) {
                bucket[2]++;
            }
            //应该找的零钱
            int change = bills[i] - 5;
            while (bucket[0] > 0 || bucket[1] > 0 || bucket[2] > 0) {
                if (change == 0) break;
                if (change >= 20 && bucket[2] > 0) {
                    change -= 20;
                    bucket[2]--;
                } else if (change >= 10 && bucket[1] > 0) {
                    change -= 10;
                    bucket[1]--;

                } else if (change >= 5 && bucket[0] > 0) {
                    change -= 5;
                    bucket[0]--;
                }
            }
            if (change > 0) return false;
        }

        return true;
    }
}
