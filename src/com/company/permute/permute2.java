package com.company.permute;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 * 题目给的数组可以有重复，但结果不要重复
 */
public class permute2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(permutation(nums));
    }

    private static ArrayList<List<Integer>> permutation(int[] array) {
        int len = array.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(array);//排列只影响数的顺序，不会影响结果
        dfs2(array, 0, len, used, path, ans);
        return ans;
    }

    /**
     * 思想: 在排列的过程中，如果我们知道这次深度向下排列的结果和前面排列的结果是重复的，我们就及时停止遍历（剪掉），向上层返回；
     *
     * 首先一定要先排序 Arrays.sort(array);为什么需要先排序呢？
     * 因为排序后重复的元素会挨在一起，这样就可以在遍历时和上一个元素比较，如果是一样的，就有可能排列出一样的组合，所以方便去剪枝；
     *
     * 当你使用第一个数，深度去遍历到第一个叶子节点一定不会是重复的；在回溯到上一个节点，
     * 则会判断当前节点和上一个节点是一样的，并且上一个节点还没有被使用，那么你往下走树的一层深度，一定会使用这个节点（未被使用的上一个节点），
     * 那么这样就会导致排列出来的数是已经排列过的了；所以这种情况我们要剪掉，不保存这样的排列
     *
     * i>0&&array[i]==array[i-1] &&!used[i-1] 这句是核心，因为全排列的遍历是一个树ji
     *
     */
    private static void dfs2(int[] array, int depth, int len, boolean[] used, Deque<Integer> path, ArrayList<List<Integer>> ans) {
        if (len == depth) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < array.length; i++) {
                int num = array[i];
                if (used[i]) {
                    continue;
                }
                if (i>0&&array[i]==array[i-1] &&!used[i-1]){
                    continue;
                }
                path.add(num);
                used[i] = true;
                dfs2(array, depth + 1, len, used, path, ans);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
