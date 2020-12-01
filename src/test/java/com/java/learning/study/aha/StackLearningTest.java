package com.java.learning.study.aha;

import org.junit.Test;

public class StackLearningTest {
    @Test
    public void test() {
        StackLearning stackLearning=new StackLearning();
        //deciphering.getNumber(nums)
        boolean palindrome = stackLearning.isPalindrome("ahah");
        System.out.println(palindrome);
    }
}
