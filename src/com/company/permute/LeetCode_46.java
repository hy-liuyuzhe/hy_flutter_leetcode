package com.company.permute;

import java.util.*;

/**
 * 全排列
 * 回溯算法
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class LeetCode_46 {


    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1, 2, 3};
        permute(nums, ans);
//        System.out.println(permutation(nums));
        System.out.println(ans);
    }

    public static List<List<Integer>> permute(int[] nums, List<List<Integer>> ans) {
        dfs(nums, new ArrayList<>(), ans);
        return ans;
    }


    private static void dfs(int[] nums, ArrayList<Integer> tmp, List<List<Integer>> ans) {
//        System.out.println(Arrays.toString(nums) + "," + tmp);
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    ArrayList<Integer> path = new ArrayList<>(tmp);
                    path.add(num);
//                    tmp.add(num);
                    dfs(nums, path, ans);
//                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    /**
     * 这是1 2 3 为根节点的三棵树
     * 题目nums 有几个数，我们遍历几次就可以了；每遍历一次，我们就会穷举出对应数字开头的所有答案；
     * <p>
     * 35行当tmp首次添加一个数，就会调用dfs，列出这个根节点下面所有排列组合，然后在37行移除掉题目nums给出的索引数，遍历下一课树的排列组合；
     * <p>
     * 36行每递归一次，这棵树就会多排列一个数字，并且树的深度加1，因为结果集要去重所以在34行有判断
     * <p>
     * 当排列数够位数，就会结束当前层递归并且走37行移除最后一个元素，看当前层是否还可以有匹配的数据，没有就继续往回递归，移除最后一个数；
     * <p>
     * 排列位数够了就会添加到结果集30行
     */


    private static void dfs1(int[] nums, ArrayList<Integer> tmp, List<List<Integer>> ans) {
//        System.out.println(Arrays.toString(nums) + "," + tmp);
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    ArrayList<Integer> path = new ArrayList<>(tmp);
                    path.add(num);
                    dfs1(nums, path, ans);
                }
            }
        }
    }

    /**
     * dfs1版本是不需要回溯的，因为树的每一层深度都对应有自己的排列组合path集合
     */




}
