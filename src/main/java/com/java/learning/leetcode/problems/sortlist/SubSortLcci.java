package com.java.learning.leetcode.problems.sortlist;

import com.java.learning.algorithm.sort.BubbleSort;
import com.java.learning.algorithm.sort.ShellSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 */
@Component
public class SubSortLcci {
    @Autowired
    BubbleSort bubbleSort;

    public  int[] subSort(int[] array) {
        int[] resultArray = new int[2];
        resultArray[0]=resultArray[1]=-1;
        //先将int数组转换为数值流
        IntStream stream = Arrays.stream(array);
        //流中的元素全部装箱，转换为流 ---->int转为Integer
        Stream<Integer> integerStream = stream.boxed();
        //将流转换为数组
        Integer[] integers = integerStream.toArray(Integer[]::new);
        Integer[] afterArray = (Integer[]) bubbleSort.sort(integers, "ascending");
        //找到两个数组不等的 最小值]
        int min=-1;
        int max=-1;
        for (int i=0;i<array.length;i++){
            if(array[i]!=afterArray[i]){
                min=i;
                break;
            }
        }
        for (int i=array.length-1;i>=0;i--){
            if(array[i]!=afterArray[i]){
                max=i;
                break;
            }
        }
        resultArray[0]=min;
        resultArray[1]=max;
        return resultArray;
    }
}
