package com.company.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {7,3,5,1,2,8};
        int k = 3;
        int[] output = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(output));
    }

    /**
     * 方法一
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - (k - 1)];
        for (int i = 0; i < n - (k - 1); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) { //1+k 同步移动
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 3 5 7 2 1 8
     * 比如K=3
     * 使用双端队列首先把滑块的前3个比较出最大的,然后移动滑动一个位置,
     * 校验参数
     * 1. 是否窗口大于3个了,移除头元素
     * 2. 窗口里取数据放入队列, 如果新放入的比队列里最大的数大, 就清空队列, 每次取出窗口的最大值, 然后移动一位,继续比较
     * 方法二
     */

    private static int[] maxSlidingWindow2(int[] nums, int k) {
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(nums, i, k);
            deq.addLast(i);
            if (nums[i] > nums[max_idx]) { //保存做大索引
                max_idx = i;
            }
        }
        int n = nums.length;
        int[] output = new int[n - (k - 1)];
        output[0] = nums[max_idx];

        //比较剩余元素
        for (int i = k; i < n; i++) {
            clean_deque(nums, i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()]; // 队列第一个元素永远是最大值,因为如果有最大值就会清栈
        }

        return output;
    }


    static ArrayDeque<Integer> deq = new ArrayDeque<>(); //存窗口里元素对应数组的索引

    /**
     * 7,3,5,1,2,8
     * 窗口每次满时的索引 first 0,1,2,3,4
     *                    i  3,4,5,6,7 减去k 正好对应上; 此时说明装不下了
     *
     * @param i 当前遍历数组的索引
     * @param k 窗口元素的数量
     */
    private static void clean_deque(int[] nums, int i, int k) {
        while (!deq.isEmpty() && deq.getFirst() == i - k) { //3-3==0
            deq.removeFirst();
        }

        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.pollLast();
        }
    }
}
