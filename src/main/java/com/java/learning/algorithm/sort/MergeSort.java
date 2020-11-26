package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 归并排序
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
@Component
public class MergeSort<T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {
    @Override
    public T[] sort(T[] array, String sortType) {
        sort(array, 0, array.length - 1, sortType);
        return array;
    }


    public void sort(T[] array, int start, int end, String sortType) {
        if (start >= end)
            return;
        int mid = (start + end) /2;
        // 递归实现归并排序
        sort(array, start, mid, sortType);
        sort(array, mid + 1, end, sortType);
        mergeSort(array, start, mid, end, sortType);
    }


    /**
     * 对start到mid跟mid+1到end两个有序数组进行排序
     * 开辟额外空间
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    public void mergeSort(T[] array, int start, int mid, int end, String sortType) {
        //如果是这样，那就是相邻的两个元素互相比较
        if (start == mid || mid == end) {
            if (!compare(array, start, end, sortType))
                swap(array, start, end);
            return;
        }
        int length = end - start + 1;
        //先整个新数组
        T[] newArray = Arrays.copyOfRange(array, start, end + 1);
        //第二段开始的指针
        int startPointer = start;
        //第一段开始的指针
        int midPointer = mid + 1;
        for (int i = 0; i < length; i++) {
            //两边指针都在的情况下
            if (startPointer <= mid && midPointer <= end) {
                if (!compare(array, startPointer, midPointer, sortType)) {
                    newArray[i] = array[midPointer];
                    midPointer++;
                } else {
                    newArray[i] = array[startPointer];
                    startPointer++;
                }
            } else if (startPointer >= mid && midPointer <= end) {
                //左边的已经到头了，此时应该直接从右边赋值
                newArray[i] = array[midPointer];
                midPointer++;
            } else if (midPointer >= end && startPointer <= mid) {
                //右边的到头了，应该从左边赋值
                newArray[i] = array[startPointer];
                startPointer++;
            }

        }
        //新数组给旧数组赋值
        for (int j = 0; j < length; j++) {
            array[start] = newArray[j];
            start++;
        }
    }


}
