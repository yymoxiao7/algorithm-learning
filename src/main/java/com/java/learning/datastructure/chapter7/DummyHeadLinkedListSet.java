package com.java.learning.datastructure.chapter7;

import com.java.learning.datastructure.DummyHeadLinkedList;

public class DummyHeadLinkedListSet<E> implements Set<E> {
    DummyHeadLinkedList<E> dummyHeadLinkedList;

    public DummyHeadLinkedListSet() {
        dummyHeadLinkedList = new DummyHeadLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!dummyHeadLinkedList.contain(e))
            dummyHeadLinkedList.addFirst(e);
    }

    @Override
    public boolean contains(E e) {
        return dummyHeadLinkedList.contain(e);
    }

    @Override
    public void remove(E e) {
        dummyHeadLinkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return dummyHeadLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dummyHeadLinkedList.isEmpty();
    }
}
