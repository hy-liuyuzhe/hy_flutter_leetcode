package com.company.math;

//1 1 2 3 5 8 13 21
public class LeetCode_70 {
    public static void main(String[] args) {

        System.out.println(climbStairs2(3));
    }

    /**
     * 递归
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 0)
            return 1;
        if (n == 2)
            return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     */
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
