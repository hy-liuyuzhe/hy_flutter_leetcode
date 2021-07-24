package com.company.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class LeetCode_167_两数之和2 {

    public static void main(String[] args) {
        int[] arr = {0,0,3,4};
        System.out.println(Arrays.toString(twoSum2(arr, 7)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    ans[0]=i+1;
                    ans[1]=j+1;
                    return ans;
                }
            }
        }
        return ans;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        while (l<r){
            final int sum = nums[l] + nums[r];
            if (sum ==target){
                return new int[]{l+1,r+1};
            }else if (sum <target){
                l++;
            }else {
                r--;
            }
        }


        return new int[]{-1,-1};
    }

}
