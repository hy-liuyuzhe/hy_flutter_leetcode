package com.company.math;

import com.company.tree.TreeDataFactory;
import com.company.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_三数之和 {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution1(nums));
    }

    //使用排序后，重复元素在一起的技巧来去重
    public static List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);//为了剪枝，避免重复元素的计算

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {//排序的数组，后面肯定比当前大，累加只会更大
                break;
            }
            //当前元素在前一次循环已经判断过了,有满足也加到结果集了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针不断拿当前i的值和数组后面的数，去尝试合成满足三数之和为0的组合
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    //剪枝，判断是否有重复的三数之和跟当前left和right一模一样
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;//三数之和太大，减少最大值的数
                } else {
                    left++;//三数之和太小，增加最小值的数
                }
            }
        }

        return res;
    }

    /**
     * 无法去重
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }

        return res;
    }
}
