package com.company.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author liuyuzhe
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        adJustHeap(nums);
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);//最后一个小的 和第一个大的做交互
            adJustHeap(nums, 0, i);//每次最后一个排好的去掉 (n-1), 剩下的继续调整到大顶堆, 第一个是最大的
        }
    }

    private static void adJustHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) { // FIXME: 09/11/2019 因为是逆序遍历的, 所以下面肯定是排列好的
            adJustHeap(nums, i, nums.length);
        }
    }

    private static void adJustHeap(int[] nums, int i, int n) {
        int child;
        int parent;//保存的是最初的根节点
        for (parent = nums[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && nums[child] < nums[child + 1]) {// FIXME: 09/11/2019 不是数组最后一个元素,还有child+1元素; 找左右节点最大的
                child++;// 序号增1，指向右子树
            }

            if (parent < nums[child]) {
                nums[i] = nums[child];
            } else {
                //根已经是3个里最大的了, 没有交换, 不走
                break;
            }
        }
        nums[i] = parent; // FIXME: 11/11/2019 如果交换过,i接着会被赋值child(大节点的索引), 我赋值给它小的节点值
    }

    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

}
