package com.java.learning.algorithm.sort;

import java.lang.reflect.Array;

public abstract class BaseSort<T extends Comparable<T>> {
    /**
     * 升序
     */
    private static final String ASCENDING_ORDER = "ascending";
    /**
     * 降序
     */
    private static final String DESCENDING_ORDER = "descending";

    //交换元素i跟j的位置
    public void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static <T>  T[] getArray(Class<T> componentType,int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
    //按照sort类型比较数组中i跟i+1元素，返回 布尔值
    public boolean compare(T[] array, int i, String sortType) {
        //如果是升序，那么arr[i]<arr[i+1],如果是降序，那么arr[i]>arr[i+1]
        return (sortType.equals(ASCENDING_ORDER) && array[i].compareTo(array[i + 1]) < 0) ||
                (sortType.equals(DESCENDING_ORDER) && array[i].compareTo(array[i + 1]) > 0);
    }

    //按照sort类型比较数组中i跟i+1元素，返回 布尔值
    public boolean compare(T[] array, int i, int j, String sortType) {
        //如果是升序，那么arr[i]<arr[i+1],如果是降序，那么arr[i]>arr[i+1]
        return (sortType.equals(ASCENDING_ORDER) && array[i].compareTo(array[j]) < 0) ||
                (sortType.equals(DESCENDING_ORDER) && array[i].compareTo(array[j]) > 0);
    }

    //按照sort类型比较数组中i跟i+1元素，返回 布尔值
    public boolean compare(T[] array, int i, T t, String sortType) {
        //如果是升序，那么arr[i]<arr[i+1],如果是降序，那么arr[i]>arr[i+1]
        return array[i] != null && (
                (sortType.equals(ASCENDING_ORDER) && array[i].compareTo(t) < 0) ||
                (sortType.equals(DESCENDING_ORDER) && array[i].compareTo(t) > 0)
        );
    }
}
