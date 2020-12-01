package com.java.learning.algorithm.graph.chapter2;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 邻接表红黑树实现
 */
public class AdjTreeSet extends BaseGraph implements GraphInterface {
    private TreeSet<Integer>[] adj;

    public AdjTreeSet(String fileName) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("顶点数不能小于0！");
            }
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<>();
            }
            E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("边总数不能小于0！");
            }
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                //自还边判断
                if (a == b) {
                    throw new IllegalArgumentException("这条记录是自环边！");
                }
                //检查是否是平行边
                if (adj[a].contains(b)) {
                    throw new IllegalArgumentException("这条记录是平行边！");
                }
                adj[a].add(b);
                adj[b].add(a);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    @Override
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }
}
