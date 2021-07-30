package com.company.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 *
 * @author liuyuzhe
 */
public class LeetCode_944_腐烂的橘子 {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {1, 1, 1},
        };
        System.out.println(orangesRotting(grid));
    }

//    默认把开局的腐蚀橘子放队列，这是第一层；遍历它开始腐蚀附近的橘子变第二层，每迭代一次层数加1；
    public static int orangesRotting(int[][] grid) {
        //表示新鲜橘子
        int count = 0;

        //记下所有的新鲜橘子count和腐蚀橘子坐标
        Queue<int[]> rotQueue = new ArrayDeque<>();
        int R = grid[0].length;//第一行数量
        int C = grid.length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {//新鲜
                    count++;
                } else if (grid[r][c] == 2) {//腐蚀
                    rotQueue.add(new int[]{r, c});
                }
            }
        }

        //表示腐蚀时间和扩散的层数
        int round = 0;
        while (count > 0 && !rotQueue.isEmpty()) {
            round++;
            //遍历当前层
            final int n = rotQueue.size();
            for (int i = 0; i < n; i++) {
                final int[] orange = rotQueue.poll();//取出当前层每一个元素
                int r = orange[0];
                int c = orange[1];
                //查看当前层每个元素上下左右是否是新鲜橘子，腐蚀进行扩散
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    rotQueue.add(new int[]{r - 1, c});
                }
                if (r + 1 < R && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    rotQueue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    rotQueue.add(new int[]{r, c - 1});
                }
                if (c + 1 < C && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    rotQueue.add(new int[]{r, c + 1});
                }
            }
        }
        System.out.println("count= " + count);
        System.out.println("round= "+round);
//        是否还剩新鲜橘子
        if (count > 0) {
            return -1;
        }
        return round;
    }
}
