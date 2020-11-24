package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 插入排序
 * 构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 */
@Component
public class InsertionSort<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {

    @Override
    public T[] sort(T[] array, String sortType) {
        //todo
        T[] resultArray = (T[]) new Comparable[array.length];
        for (int i = 0; i < array.length; i++) {
            addBySort(resultArray, i, array[i], sortType);
        }
        return resultArray;
    }

    public T[] sort(T[] array, String sortType, int gap, T[] resultArray) {
        //todo
        for (int i = 0; i * gap < array.length; i++) {
            addBySort(resultArray, i, array[i * gap], sortType, gap);
        }
        return resultArray;
    }

    private void addBySort(T[] newArray, int loopCount, T element, String sortType) {
        //在头的情况
        if (!compare(newArray, 0, element, sortType)) {
            add(newArray, 0, element);
            return;
        }
        //在中间的情况
        for (int i = 0; i < loopCount; i++) {
            //这就证明了新元素应该插入在i跟i+1中间
            if (compare(newArray, i, element, sortType) && !compare(newArray, i + 1, element, sortType)) {
                add(newArray, i + 1, element);
            }
        }
    }

    private void addBySort(T[] newArray, int loopCount, T element, String sortType, int gap) {
        //在头的情况
        if (!compare(newArray, 0, element, sortType)) {
            add(newArray, 0, element, gap);
            return;
        }
        //在中间的情况
        for (int i = 0; i < loopCount; i++) {
            //这就证明了新元素应该插入在i跟i+1中间
            if (compare(newArray, i * gap, element, sortType) && !compare(newArray, (i + 1) * gap, element, sortType)) {
                add(newArray, (i + 1) * gap, element, gap);
            }
        }
    }

}
