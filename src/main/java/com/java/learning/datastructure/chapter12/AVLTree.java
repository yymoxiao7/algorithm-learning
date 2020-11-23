package com.java.learning.datastructure.chapter12;

import java.util.ArrayList;

/**
 * 平衡二叉树
 * 首先是二分搜索树
 * 然后左右子树高度查不超过1
 *
 * @param <K> key
 * @param <V> value
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }

    }

    //根节点
    private Node root;
    //二叉树总节点数
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断该二叉树是否是一棵二分搜索树
    public boolean isBST() {
        ArrayList<K> arrayList = new ArrayList<>();
        inOrder(arrayList, root);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).compareTo(arrayList.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balance = getBalanceFactor(node);
        if (Math.abs(balance) > 1) {
            System.out.println(node.key + "  " + balance);
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }


    private void inOrder(ArrayList<K> arrayList, Node node) {
        if (node == null) {
            return;
        }
        inOrder(arrayList, node.left);
        arrayList.add(node.key);
        inOrder(arrayList, node.right);
    }

    // 判断该二叉树是否是一棵平衡二叉树

    // 获得节点node的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 获得节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else
            node.value = value;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return keepBalance(node);
    }

    private Node keepBalance(Node node) {
        //平衡维护
        int balanceFactor = getBalanceFactor(node);
        //如果 平衡因子>1 且左子树的平衡因子>0 ll
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //lr
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            //先对节点左子树左旋为ll 再右旋
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //rl
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            //先对节点的右子树右旋 为rr 再左旋
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        //rr
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        x.right = y;
        y.left = t3;
        //更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        x.left = y;
        y.right = t2;

        //更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;

    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else
            return node;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
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

    // 从二分搜索树中删除键为key的节点
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;
        Node returnNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            returnNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            returnNode = node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                returnNode = rightNode;
            } else if (node.right == null) {
                // 待删除节点右子树为空的情况

                Node leftNode = node.left;
                node.left = null;
                size--;
                returnNode = leftNode;
            } else {// 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                returnNode = successor;
            }
        }

        if (returnNode == null) {
            return null;
        }
        returnNode.height = 1 + Math.max(getHeight(returnNode.left), getHeight(returnNode.right));

        return keepBalance(returnNode);
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
}
