package com.java.learning.algorithm.graph.farmer;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int times = 0;
    private StringBuilder path;

    public Solution() {
        HashSet<String> source = new HashSet<>();
        source.add("sheep");
        source.add("wolf");
        source.add("sheep");

        HashSet<String> target = new HashSet<>();
        String init = "person";
        Queue<String> queue = new LinkedList<>();

        queue.add(init);
        path.append("start->");
        while (!queue.isEmpty()) {
            ArrayList<String> nexts = new ArrayList<>();
            String current = queue.poll();

            for (String next : nexts) {
                if (!source.contains(next) && !(source.contains("sheep") && source.contains("wolf")) &&
                        !(source.contains("sheep") && source.contains("food"))) {
                    target.add(next);
                    if ((target.contains("sheep") && target.contains("wolf")) && (target.contains("sheep") && target.contains("food"))) {
                        target.remove(next);
                        break;
                    }
                    queue.add(next);
                    target.add(next);
                    source.remove(next);
                    path.append(next + "->");

                }
            }

        }
    }

    public int getTimes() {
        return times;
    }

    public String[] getPath() {

        return null;
    }
}
