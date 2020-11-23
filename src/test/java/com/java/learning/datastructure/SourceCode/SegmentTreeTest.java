package com.java.learning.datastructure.SourceCode;

import org.junit.Test;

public class SegmentTreeTest {
    @Test
    public void test(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);
    }
}
