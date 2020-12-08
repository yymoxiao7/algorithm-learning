package com.java.learning.algorithm.graph.weightedgraph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePrim {
    private WeightedGraph weightedGraph;
    private ArrayList<WeightedEdge> minTree;

    public PriorityQueuePrim(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
        minTree = new ArrayList<>();
        CountErgodic countErgodic = new CountErgodic(weightedGraph);
        //如果这个图里有环，那他就没有最小生成树
        if (countErgodic.getCount() > 1) return;
        boolean[] visited = new boolean[weightedGraph.V];
        visited[0] = true;
        Queue<WeightedEdge> queue = new PriorityQueue<WeightedEdge>();
        //先把所有跟0相连的边都放到队列中去
        for (int v : weightedGraph.adj(0)) {
            queue.add(new WeightedEdge(0, v, weightedGraph.getWeight(0, v)));
        }
        //遍历队列
        while (!queue.isEmpty()) {
            //从队列中取出第一个，因为优先队列本质是最小堆，所以这时候取出来的就是最小
            WeightedEdge min = queue.poll();
            if (visited[min.getW()] && visited[min.getV()]) continue;

            minTree.add(min);
            //取出最小的边中，没有被遍历过的顶点
            int next = visited[min.getV()] ? min.getW() : min.getV();
            visited[next] = true;
            for (int w : weightedGraph.adj(next)) {
                if (!visited[w]) {
                    queue.add(new WeightedEdge(next, w, weightedGraph.getWeight(next, w)));
                }
            }
        }
    }

    public ArrayList<WeightedEdge> getMinTree() {
        return minTree;
    }

}
