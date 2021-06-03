package com.company.program;

import java.util.Arrays;

/**
 * 强盗抢钱2: 动态规划
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class LeetCode_213 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob3(nums));
    }

    public static int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        //环形的房间,最后一个和第一个不能同时抢
        //1. 不抢最后一个
        //2. 不抢第一个
        return Math.max(rob3(nums, 0, nums.length - 2), rob3(nums, 1, nums.length - 1));
    }

    public static int rob3(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <=end; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
