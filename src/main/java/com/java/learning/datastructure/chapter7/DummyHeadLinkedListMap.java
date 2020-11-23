package com.java.learning.datastructure.chapter7;


public class DummyHeadLinkedListMap<K, V> implements Map<K, V> {


    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    //虚拟头结点
    private Node dummyHead;
    private int size;

    public DummyHeadLinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = get(dummyHead.next, key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        return remove(prev, key).value;
    }

    public Node remove(Node prev, K key) {
        if (prev == null || prev.next == null) {
            return null;
        }
        if (prev.next.key == key) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        if (dummyHead.next == null) {
            return null;
        }

        Node node = get(dummyHead.next, key);

        return node == null ? null : node.value;
    }

    public Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node current = node;
        while (current.next != null) {
            if (current.key.equals(key)) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public void set(K key, V value) {
        Node node = get(dummyHead.next, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new RuntimeException("key:" + key + " is  not exist~~");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
