package com.company.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode_283_移动零 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //* 找到数组中最后一个负数，以它把数组分成2部分，当对这2个数组平方后，左边负数数组是递减排序的，右边数组是递增排序的；
    private static void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int k = i; k < n; k++) {
                    if (nums[k] !=0){
                        swap(nums, i, k);
                        break;
                    }
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
