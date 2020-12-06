package com.java.learning.algorithm.graph.hamltonpath;


import com.java.learning.algorithm.graph.chapter2.AdjTreeSet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 哈密尔顿路径
 */
public class HamltonPath {
    private AdjTreeSet adj;
    private boolean[] isVisited;
    private int end;
    private int[] pre;
    private  int s;
    public HamltonPath(AdjTreeSet adj, int s) {
        this.adj = adj;
        this.s = s;
        isVisited = new boolean[adj.V()];
        pre = new int[adj.V()];
        end = -1;
        dfs(s, s, adj.V());
    }

    private boolean dfs(int current, int parent, int left) {
        isVisited[current] = true;
        pre[current] = parent;
        left--;
        if (left == 0) {
            end = current;
            return true;
        }
        for (int next : adj.adj(current)) {
            if (!isVisited[next]) {
                if (dfs(next, current, left)) return true;
            }
        }
        isVisited[current] = false;
        return false;
    }

    public Iterable<Integer> getPath() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (end == -1) return arrayList;
        int current = end;
        while (current != s) {
            arrayList.add(current);
            current = pre[current];
        }
        arrayList.add(s);
        Collections.reverse(arrayList);
        return arrayList;

    }

}
