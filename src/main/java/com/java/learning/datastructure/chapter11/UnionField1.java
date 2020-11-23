package com.java.learning.datastructure.chapter11;

//第一版并查集--根据数组
public class UnionField1 implements UnionField {
    //用数组来存放,如果数组的值一样表示在一个union中
    private int[] id;

    public UnionField1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    //找到数组下标index的元素在那个 集合中，即数组值
    private int find(int index) {
        //index合法性判断
        if (index < 0 || index > id.length) {
            throw new RuntimeException("index out of bound~!");
        }
        return id[index];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        if (isConnection(p, q)) {
            return;
        }
        int pId = find(p);
        int qId = find(q);
        //找到数组中所有跟p在同一个集合中的元素，都把他们跟q放在q的集合中
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qId) {
                id[i] = qId;
            }
        }
    }
}
