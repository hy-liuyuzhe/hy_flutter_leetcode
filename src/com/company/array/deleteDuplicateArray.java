package com.company.array;

/**
 * leetcode 26 排序数组 不重复数的length
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 有序数组
 * 你需要在 原地 删除重复出现的元素，使得每个元素只出现一次
 * @author liuyuzhe
 */
public class deleteDuplicateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        System.out.println(deleteDuplicate(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0)return 0 ;
        int count = 0;
        int temp = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp){
                count++;
            }
            temp=nums[i];
        }
        return nums.length - count;
    }

    /**
     * 2个指针 i 为慢指针 j 为快指针; i记录结果不重复元素个数
     *
     * i为慢指针在达到一定的条件后才会++
     *
     * @return 无重复数组的length
     */
    private static int deleteDuplicate(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];//慢指针往前走一步, 数组前面都是不重复的
            }
        }

        return i+1;
    }
}
