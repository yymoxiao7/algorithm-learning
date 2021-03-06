package com.java.learning.algorithm.sort;

import com.java.learning.datastructure.ArrayStack;

import java.util.Random;

public class ArrayFactory {

    public static Integer[] getIntArray() {
        Random r = new Random();
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10);
        }
        return array;
    }
}
