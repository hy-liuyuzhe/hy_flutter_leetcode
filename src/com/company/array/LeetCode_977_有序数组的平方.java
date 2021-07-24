package com.company.array;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class LeetCode_977_有序数组的平方 {

    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    //* 找到数组中最后一个负数，以它把数组分成2部分，当对这2个数组平方后，左边负数数组是递减排序的，右边数组是递增排序的；
    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[]ans = new int[n];
        for(int i=0,position=n-1,j=n-1;i<=j;){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                ans[position]=nums[i]*nums[i];
                i++;
            }else{
                ans[position]=nums[j]*nums[j];
                j--;
            }
            position--;//ans被赋值过了，position指针移动一下
        }
        return ans;
    }

}
