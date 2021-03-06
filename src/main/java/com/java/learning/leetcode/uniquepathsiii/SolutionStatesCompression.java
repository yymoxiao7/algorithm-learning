package com.java.learning.leetcode.uniquepathsiii;

/**
 * https://leetcode-cn.com/problems/unique-paths-iii/
 * 状态压缩
 * 判断第i位是否是1 visited&1<<i
 * 原来是0，赋值为1 visited+1<<i
 * 原来是1 赋值0   visited-1<<i
 */
public class SolutionStatesCompression {
    private int[][] grid;
    private int R, C;
    private int visited;
    private int start, end;
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        if (grid.length == 0) return -1;
        C = grid[0].length;
        if (grid[0].length == 0) return -1;
        visited = 0;
        int left = R * C;
        //数组处理
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    start = getNumber(i, j);
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = getNumber(i, j);
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    left--;
                }
            }
        }

        return dfs(start, left);
    }

    private int dfs(int index, int left) {
        int x = index / C, y = index % C;
        visited = visited + (1 << index);
        left--;
        if (left == 0 && index == end) {
            visited = visited - (1 << index);
            return 1;
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nextx = x + dirs[i][0];
            int nexty = y + dirs[i][1];
            if (inArray(nextx, nexty) && grid[nextx][nexty] == 0 && (visited & (1 << getNumber(nextx, nexty))) == 0)
                res += dfs(getNumber(nextx, nexty), left);
        }
        visited = visited - (1 << index);
        return res;
    }

    private boolean inArray(int nextx, int nexty) {
        return nextx >= 0 && nextx < R && nexty >= 0 && nexty < C;
    }


    private int getNumber(int i, int j) {
        return i * C + j;
    }

}
