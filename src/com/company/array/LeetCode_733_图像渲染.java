package com.company.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 *
 * @author liuyuzhe
 */
public class LeetCode_733_图像渲染 {

    public static void main(String[] args) {
//        int[][] image = {
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1},
//        };
        int[][] image = {
                {0, 0},
                {0, 0},
        };
        System.out.println(Arrays.deepToString(floodFill2(image, 0, 0, 2)));
    }

    //只有起点颜色和新节点不同才去染色
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor != newColor) {
            dfs2(image, sr, sc, originColor, newColor);
        }
        return image;
    }

//    不断的枚举周围元素，如果和起点颜色一样就改变它
    private static void dfs(int[][] image, int x, int y, int originColor, int newColor) {
        if (    x < 0
                || y < 0
                || y >= image[0].length
                || x >= image.length
                || image[x][y] == newColor
                || image[x][y] != originColor) {
            return;
        }

        image[x][y] = newColor;
        dfs(image, x - 1, y, originColor, newColor);
        dfs(image, x, y - 1, originColor, newColor);
        dfs(image, x + 1, y, originColor, newColor);
        dfs(image, x, y + 1, originColor, newColor);
    }

    //在x，y 方向上探索；上下左右
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    private static void dfs2(int[][] image, int x, int y, int originColor, int newColor) {
        if (image[x][y] == originColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {//因为是上下左右所以是4
                int mx = dx[i] + x;
                int my = dy[i] + y;
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs2(image, mx, my, originColor, newColor);
                }
            }
        }
    }

    //利用队列，把
    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            if (image[x][y] != originColor) {
                continue;
            }
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image[0].length && my >= 0 && my < image.length) {
                    queue.add(new int[]{mx, my});
                }
            }
        }
        return image;
    }
}
