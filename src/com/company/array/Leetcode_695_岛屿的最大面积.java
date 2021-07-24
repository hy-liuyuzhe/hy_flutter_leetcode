package com.company.array;

public class Leetcode_695_岛屿的最大面积 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int ans = maxAreaOfIsLand(nums);
        System.out.println(ans);
    }

//    遍历所有节点，也包括里面的岛屿
    private static int maxAreaOfIsLand(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(maxAreaOfIsLand(grid, i, j),ans);
            }
        }

        return ans;
    }

//    处理越界边界，如果节点为0不需要处理，遍历过的节点赋值为0
    private static int maxAreaOfIsLand(int[][] grid, int i, int j) {
        if (i == 0 || i == grid.length || j == 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
//        四个方向上做深度优先遍历
        int[] di = new int[]{0, 1, -1, 0};
        int[] dj = new int[]{1, 0, 0, -1};
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            ans += maxAreaOfIsLand(grid, i+di[k], j+dj[k]);
        }
        return ans;
    }
}
