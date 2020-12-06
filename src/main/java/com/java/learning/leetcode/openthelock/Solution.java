package com.java.learning.leetcode.openthelock;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 * bfs
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        HashSet<String> deadSets = new HashSet<>();
        for (String str : deadends) {
            deadSets.add(str);
        }
        //判断
        if (deadSets.contains(target)) return -1;
        if (deadSets.contains(init)) return -1;
        if (target.equals(init)) return 0;
        //bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        //记录访问过的值，跟到这个值的步数
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(init, 0);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            char[] charCurrent = current.toCharArray();
            //next
            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char c = charCurrent[i];
                //这一位+1
                charCurrent[i] = Character.forDigit((charCurrent[i] - '0' + 1) % 10, 10);
                nexts.add(new String(charCurrent));
                charCurrent[i] = c;
                //-1
                charCurrent[i] = Character.forDigit((charCurrent[i] - '0' + 9) % 10, 10);
                nexts.add(new String(charCurrent));
                charCurrent[i] = c;

            }

            for (String next : nexts) {
                if (!deadSets.contains(next) && !visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(current) + 1);
                    if (next.equals(target))
                        return visited.get(next);
                }
            }
        }
        return -1;
    }
}
