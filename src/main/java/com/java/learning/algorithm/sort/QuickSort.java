package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 快速排序
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
@Component
public class QuickSort<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {
    @Override
    public T[] sort(T[] array, String sortType) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public void sort(T[] array, int start, int end) {
        if (start > end)
            return;
        T element = array[start];
        //等于privot的区间尾下标
        int sectionStart = start;
        int sectionEnd = end;
        //i到pivotIndex 应该都比中间元素小 pivotIndex+1到end应该比她大
        while (sectionStart != sectionEnd) {
            //找出startIndex到endIndex区间第一个不符合跟element排序的
            while (array[sectionEnd].compareTo(element) >= 0 && sectionStart < sectionEnd) {
                sectionEnd--;
            }
            while (array[sectionStart].compareTo(element) <= 0 && sectionStart < sectionEnd) {
                sectionStart++;
            }

            if (sectionStart < sectionEnd) {
                //交换最大最小的位置
                swap(array, sectionStart, sectionEnd);
            }

        }
        //交换中间位置
        swap(array, start, sectionStart);
        // 递归实现归并排序
        sort(array, start, sectionStart - 1);

        sort(array, sectionStart + 1, end);
    }

}
