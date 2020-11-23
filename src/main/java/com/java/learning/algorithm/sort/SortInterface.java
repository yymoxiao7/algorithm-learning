package com.java.learning.algorithm.sort;

/**
 * 排序接口
 */
public interface SortInterface<T extends Comparable<T>> {
    /**
     * 排序
     *
     * @param array    需要排序的数组
     * @param sortType 排序类型 升序or降序
     * @return 排序后的数组
     */
    T[] sort(T[] array, String sortType);
}
