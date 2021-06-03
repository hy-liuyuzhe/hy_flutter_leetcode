package com.company.math;


public class LeetCode_1143 {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("bl","yby"));
    }

    //行是横着的, 列是竖着的,左边行5个text1,上面3列text2
    //int [ ][ ]  arr=new  int [5][3];  也可以理解为“5行3列”
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();//第一个字符串, 有5行
        int m = text2.length();//第二个字符串, 有3列
        int[][] dp = new int[n][m]; //第一个[m] 代表列, n 代表行
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        //类似矩阵
        for (int i = 0; i < n; i++) {//遍历每一行(左边竖着的)的字符,如果和第一列的第一个字符一样, 第一列后面,全变成1
            if (chars1[i] == chars2[0]){
                dp[i][0] = 1;
                for (int j = i+1; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < m; i++) {//遍历每一列, 如果和第一行的字符一样, 第一行后面都是1
            if (chars2[i] == chars1[0]){
                dp[0][i] = 1;
                for (int j = i+1; j < m; j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (chars1[i] == chars2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n-1][m-1];
    }
}
