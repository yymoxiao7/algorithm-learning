package com.java.learning.datastructure.chapter7;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    public BSTMap() {
        root = null;
        size = 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node() {
            this(null, null, null, null);
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value, null, null);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else
            node.value = value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = get(root, key);
        root = remove(root, key);
        return node == null ? null : node.value;
    }

    public Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {//这个节点就是要删除的节点
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                //如果都不为空  就删除这个节点然后用右子树中的最小节点替代
                Node minNode = minimum(node.right);
                minNode.right = removeMin(node.right);
                minNode.left = node.left;
                node.left = node.right = null;
                return minNode;
            }

        }
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }  // 删除掉以node为根的二分搜索树中的最小节点

    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    public Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return get(node.right, key);
        } else if (key.compareTo(node.key) == 0) {
            return node;
        }
        return null;
    }

    @Override
    public void set(K key, V value) {
        Node node = get(root, key);
        if (node == null) {
            throw new RuntimeException("node key:" + key + " is empty~!");
        }
        node.value = value;
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
