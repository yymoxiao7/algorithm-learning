package com.java.learning.datastructure.chapter8;

import com.java.learning.datastructure.MyArray;
import org.omg.CORBA.Object;

/**
 * 最大堆：根节点的值>左右节点
 * 堆的特性：是完全二叉树
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private MyArray<E> data;

    public MaxHeap() {
        this.data = new MyArray();
    }

    public MaxHeap(int capacity) {
        this.data = new MyArray(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new MyArray<>(arr);
        //这里要注意 是从最后一个数组元素的父节点然后依次 下沉
        for (int i = getParent(getSize() - 1); i >= 0; i--)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int getSize() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int getParent(int index) {
        if (index == 0) {
            return 0;
        }
        if (index < 0) {
            throw new RuntimeException("输入的index不合法~");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        //最后一个位置插入元素
        data.addLast(e);
        //然后开始上浮
        siftUp(getSize() - 1);
    }

    //上浮操作
    public void siftUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = getParent(index);
        E parent = data.getIndex(parentIndex);
        E current = data.getIndex(index);
        //如果当前元素大于父节点元素 就继续上浮
        if (current.compareTo(parent) > 0) {
            //当前节点跟父节点元素互换，继续上浮
            data.swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        return data.getFirst();
    }

    // 取出堆中最大元素
    public E extractMax() {
        E max = findMax();
        //交换第一个位置和最后一个位置的元素，然后删除最后一个元素，然后对第一个元素进行下沉操作
        data.swap(0, getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    //下沉操作
    private void siftDown(int index) {
        //如果左孩子的index>数组最大下标 说明没有没有孩子节点了，下沉结束
        if (leftChild(index) > getSize() - 1) {
            return;
        }

        E leftChild = data.getIndex(leftChild(index));
        int maxIndex;
        //如果右孩子节点>最大下标
        if (rightChild(index) > getSize() - 1) {
            maxIndex = leftChild(index);
        } else {
            E rightChild = data.getIndex(rightChild(index));
            //找到左右孩子中的最大值 进行比较
            maxIndex = leftChild.compareTo(rightChild) > 0 ? leftChild(index) : rightChild(index);
        }

        if (data.getIndex(index).compareTo(data.getIndex(maxIndex)) < 0) {
            data.swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E max = findMax();
        data.modify(0, e);
        siftDown(0);
        return max;
    }

}
