package com.company.array;

/**
 * leetcode 26 4
 *
 * @author liuyuzhe
 */
public class LeetCode_4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        //计算合并后的中位数,也即是分割线左边元素的个数
        int totalLeft = (n + m + 1) / 2;

        //以nums1数组来求分割线
        //要满足分割线左边元素都小于右边元素
        int l = 0, r = m;
        while (l < r) {
            //尝试第一个数组索引为i,也就是左边元素的个数
            //此处+1，避免第一个数组只有一个元素时的越界；1.避免越界 2.避免left永远小于right
            int i = l + (r - l+1) / 2;
            //左边元素总数减去我们尝试左边元素的个数
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                //左边元素有大于右边元素，重新进行二分查找;
                //往左边走走
                r = i - 1;
            } else {
                //左边元素满足小于右边元素，看看右边是否还有小于的
                l = i;
            }
        }

        int i = l;
        int j = totalLeft - i;

        //处理一些极端情况
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];//中位线左边无元素
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i]; //中位线右边无元素
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((n + m) % 2 == 1) {
            //数组总和是奇数,那么左边元素最大值就是中位数索引
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            //数组总和是偶数,那么左边元素最大值和右边最小的平均值就是中位数索引
            return (double)(Math.max(nums1LeftMax, nums2LeftMax)
                    + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }


}
