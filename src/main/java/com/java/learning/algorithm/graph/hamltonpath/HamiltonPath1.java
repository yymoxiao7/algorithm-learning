package com.java.learning.algorithm.graph.hamltonpath;

import java.util.ArrayList;
import java.util.Collections;

public class HamiltonPath1 {

    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;
    private int end;

    public HamiltonPath1(Graph G, int s){

        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        dfs(s, s, G.V());
    }

    private boolean dfs(int v, int parent, int left){

        visited[v] = true;
        pre[v] = parent;
        left --;
        if(left == 0){
            end = v;
            return true;
        }

        for(int w: G.adj(v))
            if(!visited[w]){
                if(dfs(w, v, left)) return true;
            }

        visited[v] = false;
        return false;
    }

    public ArrayList<Integer> result(){

        ArrayList<Integer> res = new ArrayList<>();
        if(end == -1) return res;

        int cur = end;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/main/resources/g1.txt");
        HamiltonPath1 hp = new HamiltonPath1(g, 0);
        System.out.println(hp.result());

        HamiltonPath1 hp2 = new HamiltonPath1(g, 1);
        System.out.println(hp2.result());
    }
}