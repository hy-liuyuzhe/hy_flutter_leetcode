package com.company.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
  https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class LeetCode_217_无重复元素 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 5, 4};
        System.out.println(noRepeat3(nums));
    }

    private static boolean noRepeat3(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return true;
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return false;
    }

    private static boolean noRepeat2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean noRepeat(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

}
