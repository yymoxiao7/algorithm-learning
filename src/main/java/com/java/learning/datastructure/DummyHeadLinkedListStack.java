package com.java.learning.datastructure;

public class DummyHeadLinkedListStack<E> implements Stack<E> {
    DummyHeadLinkedList<E> dummyHeadLinkedList;
    public DummyHeadLinkedListStack(){
        dummyHeadLinkedList=new DummyHeadLinkedList<>();
    }
    @Override
    public int getSize() {
        return dummyHeadLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dummyHeadLinkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        dummyHeadLinkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return dummyHeadLinkedList.removeLast();
    }

    @Override
    public E peek() {
        return dummyHeadLinkedList.get(dummyHeadLinkedList.getSize()-1);
    }
}
