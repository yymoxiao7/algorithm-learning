package com.java.learning.datastructure;

public class ArrayStack<E> implements Stack<E> {
    MyArray<E> array;

    public ArrayStack(int capacity) {
        array = new MyArray(capacity);
    }

    public ArrayStack() {
        array = new MyArray();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("top [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.getIndex(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
