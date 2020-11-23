package com.java.learning.datastructure.chapter11;

public interface UnionField {
    int getSize();

    boolean isConnection(int p, int q);

    void unionElement(int p, int q);
}
