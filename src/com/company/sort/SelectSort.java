package com.company.sort;

import java.util.Arrays;

import static com.company.sort.HeapSort.swap;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        System.out.println(Arrays.toString(selectSort(nums)));
    }

    /**
     * 不断的遍历未排序的数组，找到最小的放数组前面
     */
    private static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
        }
        return nums;
    }
}
