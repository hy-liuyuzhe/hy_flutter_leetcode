package com.company.sort;

import java.util.Arrays;

import static com.company.sort.HeapSort.swap;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 不断的遍历待排序的数组，每次两两比较，如果2个挨着的元素前面的大于后面就交换位置；
     * 直到遍历一遍无改变，小的元素都在前面
     */
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
