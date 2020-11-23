package com.java.learning.datastructure;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void insert(E e, int index) {
        Node prev = head;
        if (index == 0) {
            addFirst(e);
        }
        int i = 0;
        while (prev.next != null && i == index - 1) {
            prev = prev.next;
            i++;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }
    // 在链表末尾添加新的元素e
    public void addLast(E e){
        insert(e,size);
    }
}
