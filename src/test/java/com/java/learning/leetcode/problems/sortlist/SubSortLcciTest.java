package com.java.learning.leetcode.problems.sortlist;

import com.java.learning.leetcode.removelinkedlistelements.ListNode;
import com.java.learning.leetcode.removelinkedlistelements.Solution3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SubSortLcciTest {
    @Autowired
    SubSortLcci subSortLcci;
    @Test
    public void test(){
        int[] nums = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        System.out.println(Arrays.toString(subSortLcci.subSort(nums)));
    }
}
