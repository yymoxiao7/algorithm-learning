package com.java.learning.algorithm.graph.directedgraph;

import com.java.learning.algorithm.graph.chapter2.BaseGraph;
import com.java.learning.algorithm.graph.chapter2.GraphInterface;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 有向有权图
 */
public class WeightedGraph extends BaseGraph implements GraphInterface {
    private TreeMap<Integer, Integer>[] adj;
    private boolean directed;
    private int[] indegrees, outdegrees;

    public WeightedGraph(String fileName, boolean directed) {
        File file = new File(fileName);
        this.directed = directed;
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("顶点数不能小于0！");
            }
            adj = new TreeMap[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeMap<>();
            }
            E = scanner.nextInt();
            indegrees = new int[V];
            outdegrees = new int[V];
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
                if (adj[a].containsKey(b)) {
                    throw new IllegalArgumentException("这条记录是平行边！");
                }
                int weight = scanner.nextInt();

                adj[a].put(b, weight);
                if (!directed) {
                    adj[b].put(a, weight);
                } else {
                    indegrees[b]++;
                    outdegrees[a]++;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDirected(){
        return  directed;
    }
    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].containsKey(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].keySet();
    }

    @Override
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegrees[v];
    }

    public int outdegree(int v) {
        validateVertex(v);
        return outdegrees[v];
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    public void removeEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if (adj[v].containsKey(w)) E--;
        if (directed) {
            indegrees[w]--;
            outdegrees[v]--;
        }
        adj[v].remove(w);
        if (!directed) adj[w].remove(v);
    }

    public int getWeight(int v, int w) {
        return adj[v].get(w);
    }
}
