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
        T[] resultArray = (T[]) new Object[array.length];
        for(int i=0;i<array.length;i++){
            addBySort(resultArray,array,array[i],sortType);
        }
        return resultArray;
    }

    private void addBySort(T[] newArray,T[] arr, T element, String sortType) {
        for (int i = 0; i < arr.length; i++) {
            //这就证明了新元素应该插入在i跟i+1中间
            if (compare(arr, i, element, sortType) && !compare(arr, i + 1, element, sortType)) {
                add(newArray, i + 1, element);
            }
        }
    }

    private void add(T[] arr, int index, T element) {
        //最后一位必须是空的，否则无法插入
        if (arr[arr.length - 1] != null && index != arr.length - 1) {
            throw new RuntimeException("如果要插入新元素，数组最后一位必须为空！");
        }
        if (index != arr.length - 1) {
            for (int i = arr.length - 2; i >= index; i--) {
                //所有元素后挪一位
                if (arr[i] != null) {
                    arr[i + 1] = arr[i];
                }
            }
        }

        arr[index] = element;
    }
}
