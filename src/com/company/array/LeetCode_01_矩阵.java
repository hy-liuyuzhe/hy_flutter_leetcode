package com.company.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 *
 * @author liuyuzhe
 */
public class LeetCode_01_矩阵 {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        System.out.println(Arrays.deepToString(updateMatrix2(mat)));
    }

    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 100;
            }
        }
        //2个遍历包含了上下左右

        //左上角遍历,从矩阵上面往下遍历；当前元素和左边和上边比较
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >=0) {//左边不越界
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                }
                if (j - 1 >=0) {//上边不越界
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                }
            }
        }
        //右下角遍历,从矩阵下面往上遍历;判断每一个元素右边和下面是否不是默认值（100），如果不是自己本身变为1+（不是默认的值）
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {//右边不越界
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                }
            }
        }
        return dp;
    }

    //    把源点0入队，然后对齐上下左右一层一层横向遍历
    private static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            final int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }

        }

        return matrix;
    }

}
