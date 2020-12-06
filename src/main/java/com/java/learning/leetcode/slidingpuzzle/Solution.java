package com.java.learning.leetcode.slidingpuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sliding-puzzle/
 * 解法一：用string记录
 */
public class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        String init = getStringByBoard(board);
        String target = "123450";
        if (init.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(init);
        visited.put(init, 0);
        //bfs
        while (!queue.isEmpty()) {
            String current = queue.poll();
            ArrayList<String> nexts = getNext(current);
            for (String next : nexts) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(current) + 1);
                    if (next.equals(target)) return visited.get(next);
                }
            }
        }
        return -1;
    }

    /**
     * 得到当前状态的下个状态
     * 个人思路：
     * 先 换成数组 ，找到0的下标，然后四连通，然后返回合法的string即可
     *
     * @param current
     * @return
     */
    private ArrayList<String> getNext(String current) {
        ArrayList<String> nexts = new ArrayList<>();
        int[][] board = getBoardByString(current);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {

                    for (int k = 0; k < 4; k++) {
                        int nextx = i + dirs[k][0];
                        int nexty = j + dirs[k][1];
                        //合法性判断
                        if (inArray(nextx, nexty)) {
                            int temp = board[nextx][nexty];
                            board[nextx][nexty] = 0;
                            board[i][j] = temp;
                            nexts.add(getStringByBoard(board));
                            //然后数组要还原
                            board[i][j] = 0;
                            board[nextx][nexty] = temp;
                        }
                    }
                }

            }
        }
        return nexts;
    }

    private boolean inArray(int nextx, int nexty) {
        return nextx >= 0 && nextx < 2 && nexty >= 0 && nexty < 3;
    }

    private int[][] getBoardByString(String string) {
        int[][] board = new int[2][3];
        char[] chars = string.toCharArray();
        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (int)chars[k++]-'0';
            }
        }
        return board;
    }

    private String getStringByBoard(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}
