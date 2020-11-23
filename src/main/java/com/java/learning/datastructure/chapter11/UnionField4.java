package com.java.learning.datastructure.chapter11;

/**
 * 基于节点深度优化
 */
public class UnionField4 implements UnionField {
    //记录 集合
    private int[] parentTree;
    //记录集合深度
    private int[] rankTree;

    public UnionField4(int size) {
        parentTree = new int[size];
        rankTree = new int[size];
        for (int i = 0; i < size; i++) {
            parentTree[i] = i;
            rankTree[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parentTree.length;
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
    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        //处理相等
        if (isConnection(p, q)) {
            return;
        }
        //如果不想等，就把p的根节点 指向q的根节点
        int pRoot = parentTree[p];
        int qRoot = parentTree[q];
        //如果p的深度高，那就挂在q上
        if (rankTree[p] > rankTree[q]) {
            parentTree[p] = qRoot;
        }else if(rankTree[p]<rankTree[q]){
            parentTree[q] = pRoot;
        }else{
            parentTree[p] = qRoot;
            rankTree[q]++;
        }
    }
}
