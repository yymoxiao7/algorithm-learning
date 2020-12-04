package com.java.learning.algorithm.graph.chapter2;

import org.springframework.util.CollectionUtils;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 基于 红黑树实现的邻接表的图的深度优先遍历
 * 处理非联通情况
 */
public class AdjTreeSetDFSSingleSourcePath {
    private AdjTreeSet adj;
    private int[] isVisited;
    private ArrayList<Integer> preOrder = new ArrayList<>();
    private ArrayList<Integer> postOrder = new ArrayList<>();
    private int cccount = 0;
    private int[] pre;
    private int source;

    AdjTreeSetDFSSingleSourcePath(AdjTreeSet adj, int index) {
        this.adj = adj;
        this.source = index;
        isVisited = new int[adj.V];
        pre = new int[adj.V];
        for (int i = 0; i < adj.V; i++) {
            isVisited[i] = -1;
        }
        for (int i = 0; i < adj.V; i++) {
            if (isVisited[i] == -1) {
                dfs(i, cccount, i);
                cccount++;
            }
        }
    }

    /**
     * 连通数量
     *
     * @return
     */
    public int getCount() {
        for (int e : isVisited)
            System.out.print(e + " ");
        System.out.println();
        return cccount;
    }

    private void dfs(int index, int ccid, int parentId) {
        isVisited[index] = ccid;
        //先序
        preOrder.add(index);
        pre[index] = parentId;
        for (int i : adj.adj(index)) {
            if (isVisited[i] == -1) {
                dfs(i, ccid, index);
            }
        }
        postOrder.add(index);
    }

    /**
     * 判断两个顶点是否是连通的
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isConnect(int i, int j) {
        adj.validateVertex(i);
        adj.validateVertex(j);
        return isVisited[i] == isVisited[j];
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] components = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++) {
            components[i] = new ArrayList<>();
        }
        for (int j = 0; j < adj.V; j++) {
            components[isVisited[j]].add(j);
        }
        return components;
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> list = new ArrayList<>();
        if (!isConnect(source,t)) return  null;
        int current=t;
        //从尾开始遍历
        while(current!=source){
            list.add(current);
            current=pre[current];
        }
        list.add(source);
        //数组反转
        Collections.reverse(list);
        return list;
    }

    public Iterable<Integer> getPreOrder() {
        return preOrder;
    }

    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

}
