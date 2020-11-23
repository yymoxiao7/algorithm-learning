package com.java.learning.datastructure;

public class MyArray<E> {
    private E[] array;
    private int size;

    //构造函数 有参
    public MyArray(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }
    public MyArray(E[] arr){
        array = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            array[i] = arr[i];
        size = arr.length;
    }
    //构造函数 无参
    public MyArray() {
        this(10);
    }

    //获取数组容量
    public int getCapacity() {
        return array.length;
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return getSize() == 0;
    }

    //在index位置插入元素
    public void add(int index, E e) {
        judgeIndex(index);
        //如果size=etCapacity() 扩容
        if (size == array.length) {
            resize(size * 2);
        }
        for (int i = size; i > index; i--)
            array[i] = array[i - 1];
        array[index] = e;
        size++;
    }

    private void judgeIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("你传入的index不合法，请检查~~");
        }
    }

    //在数组最后一个位置插入元素 todo
    public void addLast(E e) {
        add(size, e);
    }

    //在数组最开始插入元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获取index位置的元素
    public E getIndex(int index) {
        judgeIndex(index);
        return array[index];
    }

    //修改
    public void modify(int index, E e) {
        judgeIndex(index);
        array[index] = e;
    }

    //查找元素是否存在
    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i > size; i++) {
            if (array[i].equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    //从index位置删除 元素并返回
    public E remove(int index) {
        judgeIndex(index);
        E e = array[index];
        for (int i = index; i < size; i++) {
            if (i == array.length - 1) {
                array[i] = null;
                break;
            }
            array[i] = array[i + 1];
        }
        size--;
        //缩容
        if (size == array.length / 4 && array.length != 0) {
            resize(array.length / 2);
        }
        return e;
    }

    //删除第一个元素并返回
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素并返回
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                remove(i);
            }
        }
    }

    //改变数组容量
    public void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    //返回数组第一个元素
    public E getFirst() {
        return getIndex(0);
    }

    //返回最后一个元素
    public E getLast() {
        return getIndex(size - 1);
    }

    public void swap(int i, int j) throws RuntimeException {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new RuntimeException("swap index不合法！i:" + i + ",j:" + j);
        }
        E e = array[i];
        array[i] = array[j];
        array[j] = e;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, array.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(array[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
