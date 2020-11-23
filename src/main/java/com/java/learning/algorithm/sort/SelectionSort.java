package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
  */
@Component
public class SelectionSort<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {
    @Override
    public T[] sort(T[] array, String sortType) {
        int length = array.length;
        if (length <= 1) {
            return array;
        }
        for (int i = 0; i <length; i++) {
            //找到最小或者最大元素的下标
            int index = findMinOrMax(array, i, length, sortType);
            //把最大或者最小的元素跟最后一个交换
            swap(array, i, index);
        }
        return array;
    }

    private int findMinOrMax(T[] arr, int start, int end, String sortType) {
        if (start - end == 0) {
            return start;
        }
        //最小或者最大的元素
        int index = start;
        for (int i = start; i < end; i++) {
            if (!compare(arr,index, i, sortType)) {
                index = i;
            }
        }

        return index;
    }
}
