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

    public static <T> T[] getArray(Class<T> componentType, int length) {
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

    public void add(T[] arr, int index, T element) {
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

    public void add(T[] arr, int index, T element, int gap) {
        //最后一位必须是空的，否则无法插入
        if (arr[arr.length - gap] != null && index != arr.length - gap) {
            throw new RuntimeException("如果要插入新元素，数组最后一位必须为空！");
        }
        if (index != arr.length - gap) {
            for (int i = arr.length  - gap; i >= index; i = i - gap) {
                //所有元素后挪gap位
                if (arr[i] != null) {
                    arr[i + gap] = arr[i];
                }
            }
        }

        arr[index] = element;
    }
}
