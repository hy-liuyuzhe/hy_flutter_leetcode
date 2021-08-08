package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_120_三角形最小路径和 {
    public static void main(String[] args) {
        Integer[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        final List<List<Integer>> list = twoDArrayToList(triangle);

        System.out.println(minimumTotal3(list));
    }
    public static <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
        List<List<T>> list = new ArrayList<>();
        for (T[] array : twoDArray) {
            list.add(Arrays.asList(array));
        }
        return list;
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for (int j = 0; j <=i; j++) {
              dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

//    因为只使用了下一行的数组，所以使用一个数组就能满足
    public static int minimumTotal2(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            for (int j = 0; j <=i; j++) {
              dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static int minimumTotal3(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
//        System.out.println("i= "+i +">>> j= "+j);
//        取下层的最小值
        final int min = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1));
        System.out.println(min);
        return min + triangle.get(i).get(j);
    }

}
