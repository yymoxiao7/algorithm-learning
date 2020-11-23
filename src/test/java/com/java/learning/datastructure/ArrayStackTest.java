package com.java.learning.datastructure;

import org.junit.Test;

public class ArrayStackTest {
    @Test
    public void test(){

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
    }

}
