package com.company.permute;

import java.util.*;

/**
 * 全排列
 * 1.不包含重复是n！；n*(n-1)... * 3*2*1
 * 2.包含重复是n的n次幂
 *
 */
public class permute3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<List<Integer>> list = permutation(nums);
        System.out.println(list.size());
        System.out.println(list);
    }

    private static ArrayList<List<Integer>> permutation(int[] array) {
        int len = array.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs3(array, -1, path, ans);
        return ans;
    }

    /**
     * -1为root节点，树结构
     *
     */
    private static void dfs3(int[] nums, int index, Deque<Integer> path, ArrayList<List<Integer>> ans) {
        if (path.size() == nums.length) {
            return;
        }
        if (index!=-1)path.add(nums[index]);
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }

//        dfs3(nums, 0, path, ans);
//        dfs3(nums, 1, path, ans);
//        dfs3(nums, 2, path, ans);
        for (int i = 0; i < nums.length; i++) {
            dfs3(nums, i, path, ans);
        }
        if (index!=-1) path.removeLast();
    }
}
