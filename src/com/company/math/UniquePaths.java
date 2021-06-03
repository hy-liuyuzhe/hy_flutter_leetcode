package com.company.math;

import java.util.Arrays;

/**
 * LeetCode 62 不同路径 https://leetcode-cn.com/problems/unique-paths/solution/xiao-xue-ti-java-by-biyu_leetcode/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。  m x n  width * height
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println("result: "+uniquePaths(4, 3));
    }


    /**
     * left and top all 1, left+top , bottom_right is correct answer
     * @param m 是列 如 4列, 遍历3次就行, 默认第一个方格为1
     * @param n 是行
     */
    public static int uniquePaths(int m, int n) {
        int[] memo = new int[n]; //数组持久的是方块格的一列数据, 默认在第一列
        Arrays.fill(memo, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[j] += memo[j - 1];
                System.out.println("内循环的值: "+memo[j - 1]);
            }
            // FIXME: 2020/10/20 外圈每走一遍, 一列就会被赋值
            System.out.println("i: "+i+"===>"+Arrays.toString(memo));
        }
        //数组已经走到的了最后一列, 最后一个列的数就是结果
        return memo[n - 1];
    }
}
