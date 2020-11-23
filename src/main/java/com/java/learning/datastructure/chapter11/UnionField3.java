package com.java.learning.datastructure.chapter11;

/**
 * 根据节点下面的元素个数来优化
 */
public class UnionField3 implements UnionField {
    private int[] parentTree;
    private int[] sizeTree;

    public UnionField3(int size) {
        parentTree = new int[size];
        sizeTree = new int[size];
        for (int i = 0; i < size; i++) {
            parentTree[i] = i;
            sizeTree[i] = 1;
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
        //如果p的子节点数量比q多，就 挂在q上
        if (sizeTree[p] > sizeTree[q]) {
            parentTree[p] = qRoot;
            sizeTree[q] += sizeTree[p];
        }else{
            parentTree[q] = pRoot;
            sizeTree[p] += sizeTree[q];
        }
    }
}
