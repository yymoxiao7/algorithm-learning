package com.java.learning.leetcode.uniquepaths;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 图论求连通分量
 * 先返回个最短路径把
 */
public class Solution {
    //路径数
    private int ccount;
    //访问记录
    private int[][] visited;

    public int uniquePaths(int m, int n) {
        visited = new int[m][n];
        ccount = 0;

        return ccount;
    }

}
