package com.company.sort;

import java.util.Arrays;

import static com.company.sort.HeapSort.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        boolean hasChange = true;

        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

}
