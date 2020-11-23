package com.java.learning.datastructure.chapter6;

import org.junit.Test;

import java.util.ArrayList;

public class BSTTest {
    @Test
    public void test() {
        BST<Integer> bst = getIntegerBST();

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        System.out.println(bst);
    }

    private BST<Integer> getIntegerBST() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);
        return bst;
    }

    @Test
    public void testInOrder() {
        BST<Integer> bst = getIntegerBST();

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();
    }
    @Test
    public void remove(){
        BST<Integer> bst = getIntegerBST();
        ArrayList<Integer> nums = new ArrayList<>();

            nums.add(bst.removeMin());
        System.out.println(nums);

            nums.add(bst.removeMax());
        System.out.println(nums);

    }
}
