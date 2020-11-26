package com.java.learning.algorithm.sort;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class sortTest {
    @Autowired
    BubbleSort bubbleSort;
    @Autowired
    SelectionSort selectionSort;
    @Autowired
    InsertionSort insertionSort;
    @Autowired
    ShellSort shellSort;
    @Autowired
    ShellSortImprove shellSortImprove;
    @Autowired
    MergeSort mergeSort;
    @Autowired
    QuickSort quickSort;

    @Test
    public void bubbleSort() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        arr = (Integer[]) bubbleSort.sort(arr, "ascending");
        System.out.println("after:" + Arrays.toString(arr));
    }

    @Test
    public void selectionSort() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        arr = (Integer[]) selectionSort.sort(arr, "ascending");
        System.out.println("after:" + Arrays.toString(arr));
    }

    @Test
    public void insertionSort() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        arr = (Integer[]) insertionSort.sort(arr, "ascending");
        System.out.println("after:" + Arrays.toString(arr));
    }

    @Test
    public void shellSort() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        arr = (Integer[]) shellSort.sort(arr, "ascending");
        System.out.println("after:" + Arrays.toString(arr));
    }

    @Test
    public void shellSortImprove() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        arr = (Integer[]) shellSortImprove.sort(arr, "ascending");
        System.out.println("after:" + Arrays.toString(arr));
    }

    @Test
    public void MergeSort() {
        Integer[] arr = ArrayFactory.getIntArray();
        System.out.println("befor:" + Arrays.toString(arr));
        mergeSort.sort(arr, "ascending");
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void QuickSort() {
/*
        Integer[] arr = ArrayFactory.getIntArray();
*/
        Integer[] arr = new Integer[]{8, 0, 3, 3, 4, 2, 3, 8, 5, 0};
        System.out.println("befor:" + Arrays.toString(arr));
        quickSort.sort(arr, "ascending");
        System.out.println(Arrays.toString(arr));

    }
}
