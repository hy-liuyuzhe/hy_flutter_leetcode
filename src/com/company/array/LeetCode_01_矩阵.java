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
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }



    private static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] ==0){
                    queue.offer(new int[] {i, j});
                }else {
                    matrix[i][j]=-1;
                }
            }
        }

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            final int[] point = queue.poll();
            int x = point[0]; int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (newX>=0 && newX<m && newY>=0 && newY<n && matrix[newX][newY]==-1){
                    matrix[newX][newY] = matrix[x][y]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }

        }

        return matrix;
    }

}
