package com.company.math;

/**
 * 二分查找排序
 * @author liuyuzhe
 */
public class leetcode278 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(binarySearchSort(nums, 11));
    }

    //取中间值进行比较，如果等于就找到并且返回其索引，如果小于则目标值在右边，如果大于则在左边；不断重复取中间值查找
    private static int binarySearchSort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
