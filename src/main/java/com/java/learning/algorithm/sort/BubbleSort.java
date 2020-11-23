package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 冒泡排序
 * 时间复杂度O（n^2）
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
@Component
public class BubbleSort<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {

    /**
     * @param array    需要排序的数组
     * @param sortType 排序类型 升序or降序
     * @return 排序后的数组
     */
    @Override
    public T[] sort(T[] array, String sortType) {
        int length = array.length;
        //如果数组长度<-=1就不用排序了，直接返回
        if (length <= 1) {
            return array;
        }

        for (int i = 0; i < length; i++) {
            //里层
            for (int j = 0; j < length - 1; j++) {
                if (!compare(array, j, sortType)) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
}
