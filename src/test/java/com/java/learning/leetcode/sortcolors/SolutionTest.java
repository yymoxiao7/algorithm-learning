package com.java.learning.leetcode.sortcolors;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        int intA[]={2,0,2,1,1,0};
        (new Solution1()).sortColors(intA);
        System.out.println(intA);
    }

    @Test
    public void test1(){
        int intA[]={2,2};
        (new Solution()).sortColors(intA);
        System.out.println(intA);
    }
}
