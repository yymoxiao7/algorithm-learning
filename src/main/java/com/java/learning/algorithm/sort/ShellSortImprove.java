package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 希尔算法改进版本
 *
 * @param <T>
 */
@Component
public class ShellSortImprove<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {
    @Override
    public T[] sort(T[] array, String sortType) {
        int length = array.length;
        //对步长进行循环
        for (int gap = length / 2; gap >= 1; gap = gap / 2) {
            //从gap的位置开始循环
            for (int i = gap; i < length; i++) {
                int temp = i;
                //比较temp-gap跟temp，如果不符合就 交换元素，并且比较temp-gap*2跟temp-gap。。
                while (temp - gap >= 0 && !compare(array, temp - gap, temp, sortType)) {
                    swap(array, temp - gap, temp);
                    temp = temp - gap;
                }
            }
        }
        return array;
    }
}
