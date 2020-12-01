package com.java.learning.algorithm.graph.chapter2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 邻接矩阵
 */
public class AdjMatrix extends BaseGraph implements GraphInterface {
    //二维数组存储
    private int[][] adj;

    public AdjMatrix(String fileName) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("顶点数不能小于0！");
            }
            adj = new int[V][V];
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
                if (adj[a][b] == 1) {
                    throw new IllegalArgumentException("这条记录是平行边！");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    @Override
    public int degree(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }

        }
        return res.size();
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
