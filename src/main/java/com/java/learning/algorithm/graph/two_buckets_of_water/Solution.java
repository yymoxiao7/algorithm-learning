package com.java.learning.algorithm.graph.two_buckets_of_water;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.*;

/**
 * 两桶水，一个水桶5升一个水桶3升
 * 怎么得到4L水
 */
public class Solution {
    private Integer[] pre;
    private int end = -1;

    public Solution() {
        int x = 0, y = 0;
        //用两位数表示水桶x跟水桶y里面的水
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        queue.add(0);
        visited.put(0, 0);
        pre = new Integer[100];
        pre[0] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ArrayList<Integer> nexts = new ArrayList<>();
            x = current / 10;
            y = current % 10;
            nexts.add(5 * 10 + y);
            nexts.add(x * 10 + 3);
            nexts.add(x * 10);
            nexts.add(y);
            int xToy = Math.min(x, 3 - y);
            int yToX = Math.min(y, 5 - x);
            nexts.add((x + yToX) * 10 + y - yToX);
            nexts.add((x - xToy) * 10 + (xToy + y));
            for (int next : nexts) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    pre[next] = current;
                    visited.put(next, visited.get(current) + 1);
                    if (next / 10 == 4 || next % 10 == 4)
                        end = next;
                    return;
                }
            }
        }
    }

    public Iterable<Integer> getPath() {
        ArrayList<Integer> path = new ArrayList<>();
        if (end == -1) return path;
        int current = end;
        while (current != 0) {
            path.add(current);
            current = pre[current];
        }
        path.add(0);
        Collections.reverse(path);
        return path;

    }


    //x的水倒掉
    private int case1(int x, int y) {
        x = 0;
        return x * 10 + y;
    }

    //y的水倒掉
    private int case2(int x, int y) {
        y = 0;
        return x * 10 + y;
    }

    //x的水加班
    private int case3(int x, int y) {
        x = 5;
        return x * 10 + y;
    }

    //y的水加班
    private int case4(int x, int y) {
        y = 3;
        return x * 10 + y;
    }

    //x的水倒给y
    private int case5(int x, int y) {
        x = x - (3 - y);
        return x * 10 + y;
    }

    //y的水倒给x
    private int case6(int x, int y) {
        y = y - (5 - x);
        return x * 10 + y;
    }
}
