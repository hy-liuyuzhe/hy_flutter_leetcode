package com.company.array;

/**
 * 缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class Offer53 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 9};

        System.out.println(missingNumber(arr));
    }


    public static int missNumber(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i)return i;
        }
        return nums.length;
    }

    /**
     * 有序的, 首先想使用二分法
     */
    public static int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                //丢失的数在右边
                low = mid + 1;
            } else {
                //丢失的数在左边
                high = mid - 1;
            }
        }
        return low;
    }
}
