package com.java.learning.leetcode.emonadechange;

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
public class Solution1 {

    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) return false;
        //记录存钱 0代表5元 1代表10元，2代表20
        int m5 = 0, m10 = 0;
        //队列初始化
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                m5++;
            } else if (bills[i] == 10) {
                m10++;
                if (m5 > 0) {
                    m5--;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                //此时应该找15
                if (m10 > 0 && m5 > 0) {
                    m10--;
                    m5--;
                } else if (m5 >= 3) {
                    m5 -= 3;
                } else {
                    return false;
                }
            }

        }

        return true;
    }
}
