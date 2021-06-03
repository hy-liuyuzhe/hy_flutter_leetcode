package com.company.tree;


import java.util.Arrays;


/**
 * 旋转矩阵
 * <p>
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */
public class LeetCode_48_旋转矩阵 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate2(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    /**
     * 先水平后对角线 进行翻转来代替旋转
     *
     * 1. matrix[row][col]→ 水平轴翻转 matrix[n−row−1][col] , 他的第一行对应我的最后一行
     *
     * 2. matrix[row][col]→ 主对角线翻转 matrix[col][row], 他的第1行第0个元素对应我的第0行第1元素 如13
     *
     * 15 14 12 16                   15 13  2  5
     * 13  3  6  7   =主对角线翻转=>   14  3  4  1
     *  2  4  8 10                   12  6  8  9
     *  5  1  9 11                   16  7 10 11
     *
     */
    public static void rotate2(int[][] matrix){
        //水平翻转, 只交换一面一次就可以; 所以除以2
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
            for (int j = 0; j < i; j++) { //注意这里是 j<i , 只会遍历对角线左边的元素 就够了
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[j][i];
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
//                matrix_new[i][j] = nums[n - 1-j][i];

                //在根据每一行遍历源数组的每一个元素时, 我们对新数组的每一列的每一个元素进行赋值; 拿出一行, 我们会赋值3列.
                matrix_new[j][n - 1 - i] = nums[i][j];//左边一行, 右边最后一列
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = matrix_new[i][j];
            }
        }
    }

}
