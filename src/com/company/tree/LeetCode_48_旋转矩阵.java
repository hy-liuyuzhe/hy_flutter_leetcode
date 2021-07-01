package com.company.tree;


import java.util.Arrays;


/**
 * 旋转矩阵
 * <p>
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */
public class LeetCode_48_旋转矩阵 {

    public static void main(String[] args) {
//        int[][] nums = {{1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9}};
        int[][] nums = {{5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16},
        };
        rotate3(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    /**
     * 先水平后对角线 进行翻转来代替旋转；
     *
     * 1. matrix[row][col]→ 水平轴翻转 matrix[n−row−1][col] , 矩阵横向的中间切开，上下两个部分进行交换
     *
     * 2. matrix[row][col]→ 主对角线翻转 matrix[col][row], 上下三角矩阵，每个元素一一交换
     *
     * 15 14 12 16                   15 13  2  5
     * 13  3  6  7   =主对角线翻转=>   14  3  4  1
     *  2  4  8 10                   12  6  8  9
     *  5  1  9 11                   16  7 10 11
     *
     */
    public static void rotate2(int[][] matrix){
        //水平翻转, 遍历一半的元素，上下面交换一次就够了
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        //主对角线翻转
        for (int i = 0; i < n; i++) {
                //注意这里是 j<i , 只会遍历对角线左边的元素 就够了
                //（0-不转换，1对角线左边一个元素，2对角线左边2个元素。。。）
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];//[row][col]
                matrix[i][j]  = matrix[j][i];//[col][row]
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * {
     * <p>
     * {1,2,3},        {7,4,1},
     * {4,5,6},  ->    {8,5,2},
     * {7,8,9}         {9,6,3}
     * <p>
     * }
     * <p>
     * 使用了额外的数组
     * <p>
     * 对于矩阵中 第i行第j元素 , 转换后 出现 倒数第i列 第j的位置
     * <p>
     * [i][j] => [j][n−i−1]
     * [col][n−row−1]=matrix[row][col]
     */
    public static void rotate(int[][] nums) {
        int n = nums.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) { //row
            for (int j = 0; j < n; j++) { //col
                //把每一行的每一个元素，赋值到右边每一列的每一个元素
                matrix_new[j][n - 1 - i] = nums[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     *  步骤4   |  步骤3
     *  -------|--------
     *  步骤1   | 步骤 2
     *
     *  👆🏻是右边赋值操作：
     *  步骤1 内循环最左边一列进行旋转，然后第二列...
     *  步骤2 内循环最下面一行，然后倒数第二行...
     *  步骤3 内循环最右面一列，然后倒数第二列...
     *  步骤4 内循环最上面一行，然后第二行...
     *
     *  int tmp = matrix[row][col]; 相当于我们使用局部变量持久化了一份数据做缓存；
     *  matrix[row][col]这个位置我们可以对其覆盖数据进行赋值了，因为我们有缓存了
     *  顺时针，依次对步骤4，步骤1，步骤2，步骤3，区域的位置进行赋值
     *
     *  为什么内循环(n + 1) / 2？
     *  当集合n为奇数时，是由3*2的小方块组成一共有4个+一个中心小方块；
     *  因为矩阵是被拆分成4份，当集合n为奇数时，比如5至少旋转3个才能满足都旋转到；当奇数中心元素不用动
     */
    public static void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n/2; row++) {
            for (int col = 0; col < (n + 1) / 2; col++) {
                System.out.println("步骤1= "+matrix[n - col - 1][row]
                        +"  步骤2= "+matrix[n - row - 1][n - col - 1]+"   步骤3= "+matrix[col][n - row - 1]
                        +"  步骤4= "+matrix[row][col]);

                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];//1
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];//2
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];//3
                matrix[col][n-row-1] = tmp;//4


            }
        }
    }

}
