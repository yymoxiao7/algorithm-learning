package com.java.learning.algorithm.sort;

import org.springframework.stereotype.Component;

/**
 * 记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 * @param <T>
 */
@Component
public class ShellSort <T extends Comparable<T>> extends BaseSort<T> implements SortInterface<T> {

    @Override
    public T[] sort(T[] array, String sortType) {
        return null;
    }
}
