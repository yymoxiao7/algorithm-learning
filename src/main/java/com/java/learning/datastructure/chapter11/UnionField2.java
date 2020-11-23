package com.java.learning.datastructure.chapter11;

/**
 * 第二版 用树表示
 */
public class UnionField2 implements UnionField {
    private int[] parentTree;
    private int[] size;

    public UnionField2(int size) {
        parentTree = new int[size];
        for (int i = 0; i < size; i++) {
            parentTree[i] = i;
        }
    }

    /**
     * 查找对应的集合编号
     *
     * @param index
     * @return
     */
    private int find(int index) {
        //合法性判断
        if (index < 0 || index >= parentTree.length) {
            throw new RuntimeException("index out of bound~~");
        }
        //如果 是跟节点，那么她的值等于下标
        while (parentTree[index] != index) {
            index = parentTree[index];
        }
        return parentTree[index];
    }

    @Override
    public int getSize() {
        return parentTree.length;
    }

    @Override
    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 复杂度o（h）h是树高度
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElement(int p, int q) {
        //处理相等
        if (isConnection(p, q)) {
            return;
        }
        //如果不想等，就把p的根节点 指向q的根节点
        int pRoot = parentTree[p];
        int qRoot = parentTree[q];
        parentTree[pRoot] = qRoot;
    }
}
