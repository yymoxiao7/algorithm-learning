package com.java.learning.datastructure.chapter9;


public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merge<E> merge;

    public SegmentTree(E[] arr, Merge<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > getSize()) {
            throw new RuntimeException("get index error~!");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 在treeIndex的位置创建表示区间[l...r]的线段树
    public void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = (l + r) / 2;
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);
        //父节点的值=按照 业务需求将左右子节点合在一起
        tree[treeIndex] = (E) merge.merge(tree[leftChild], tree[rightChild]);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryR >= data.length) {
            throw new RuntimeException("query index error!");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //如果查找的区间恰巧就是treeIndex
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = (l + r) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftChideIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        //如果在右边
        if (queryL >= mid + 1) {
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else if (mid >= queryR) {
            return query(leftChideIndex, l, mid, queryL, queryR);
        }
        //如果两边都有
        E leftResult = query(leftChideIndex, l, mid, queryL, mid);
        E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);


        return merge.merge(leftResult, rightResult);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r && treeIndex == index) {
            tree[treeIndex] = e;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = (l + r) / 2;
        if (index >= mid + 1) {
            set(rightChild, mid + 1, r, index, e);
        } else {
            set(leftChild, l, mid, index, e);
        }
        tree[treeIndex] = merge.merge(tree[leftChild], tree[rightChild]);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
