package com.company.array;

/**
 * 长度为n的字符串:
 * 子串(必须连续挨着)有n(n+1)/2个
 * <p>
 * 子序列有2的n次方
 * <p>
 *
 *
 */
public class Offer42 {

    /**
     * 求最大子串的和, 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * -2,1,-3,4,-1,2,1,-5,4
     *
     * [-2,1,-3,4,-1,2,1,-5,4] 他的连续子串, 相加为6
     */
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(arr));
    }

    /**
     * 若nums[i - 1]<0说明 nums[i-1]+nums[i] 还不如nums[i], 起负贡献
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);//取遍历列表前一个数与当前数相加
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        int temp = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];//不断前进,求和, 找最大值
            if(temp > max) max = temp;
            if(temp < 0) temp = 0;//一旦小于0, 说明前面都是负贡献, 从新计算
        }
        return max;
    }

}
