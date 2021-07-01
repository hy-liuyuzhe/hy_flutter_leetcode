package com.company.sort;

import java.util.Arrays;
/**
 * 归并排序，大的问题拆分成小的，小到直接求解
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2,1,7,9,5,8};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
*         {2,1,7,9,5,8}
     * {2,1,7}    {9,5,8};
     *
     * 一个数组在中间拆分成2个子节点，按照后序遍历不断在中间拆分到只有一个元素。左右子树，不断的按照大小顺序进行合并，最后
     * 合并成一个新的根节点数组
     *
     */
    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) { //只剩下最后一个元素直接返回(一个)
            return;
        }
        int mid = lo + (hi - lo) / 2; //递归拆分成0,1 ; 2,3  只有2个可直接求解的数组
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        System.out.println("最小索引："+lo+" 中间："+mid+" 最大索引："+hi);
        merge(nums, lo, mid, hi);
    }


    /**
     *
     * 【1，2，7】以i    ，   【5，8，9】以j
     *
     * 【 ， ， ， ， ， 】以k为起点
     *
     *
     * 这三个数组，j和i索引的元素进行比较，把比较后小的元素放入k为起点的数组里，并且每比较一次k跟i或j的索引都要同步向右移动一个位置
     *
     * 为什么需要clone一个数组？在进入方法我们要保留一份完整的数组，以便在交换位置时使用；
     *
     * @param lo 表示当前这个方法要合并数组的起始点，使用 i 和 k 局部变量记录下；
     * @param mid 要合并数组的中间位置
     * @param hi 要合并数组的最大索引位置
     * @param j  以中间位置拆分的右边数组的起始索引，mid+1得出来的
     */
    private static void merge(int[] nums, int lo, int mid, int hi) {
        int k = lo, i = lo , j = mid + 1;
        int[] copy = nums.clone();
        while (k <= hi) {
            if (i > mid) { //左边排列完了,右边的数直接放到最终数组的后面
                nums[k++] = copy[j++];
            } else if (j > hi) { //右边排列完了,左边的数直接放到最终数组的后面
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) { //步骤 1. 先比较大小
                nums[k++] = copy[j++]; //左边数组里元素大
            } else {
                nums[k++] = copy[i++]; //右边数组里元素大
            }
        }
    }
}
